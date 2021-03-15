#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
# mdict.py
# MDict Dictionary File (.mdx) and Resource File (.mdd) Analyser
#
# Copyright (C) 2012, 2013, 2015 Xiaoqiang Wang <xiaoqiangwang AT gmail DOT com>
#
# This program is a free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, version 3 of the License.
#
# You can get a copy of GNU General Public License along this program
# But you can always get it from http://www.gnu.org/licenses/gpl.txt
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU General Public License for more details.

from struct import pack, unpack
from io import BytesIO
import re
import sys

from ripemd128 import ripemd128
from pureSalsa20 import Salsa20

# zlib compression is used for engine version >=2.0
import zlib


def _fast_decrypt(data, key):
    b = bytearray(data)
    key = bytearray(key)
    previous = 0x36
    for i in range(len(b)):
        t = (b[i] >> 4 | b[i] << 4) & 0xff
        t = t ^ previous ^ (i & 0xff) ^ key[i % len(key)]
        previous = b[i]
        b[i] = t
    return bytes(b)


def _fast_encrypt(data, key):
    b = bytearray(data)
    key = bytearray(key)
    previous = 0x36
    for i in range(len(b)):
        t = b[i] ^ previous ^ (i & 0xff) ^ key[i % len(key)]
        previous = b[i] = ((t >> 4) | (t << 4)) & 0xff
    return bytes(b)


def _mdx_decrypt(comp_block):
    key = ripemd128(comp_block[4:8] + pack(b'<L', 0x3695))
    return comp_block[0:8] + _fast_decrypt(comp_block[8:], key)


def _mdx_encrypt(comp_block):
    key = ripemd128(comp_block[4:8] + pack(b"<L", 0x3695))
    return comp_block[0:8] + _fast_encrypt(comp_block[8:], key)


def _salsa_decrypt(ciphertext, dict_key):
    assert(type(ciphertext) == bytes)
    assert(type(dict_key) == bytes)
    decrypt_key = ripemd128(dict_key)
    s20 = Salsa20(key=decrypt_key, IV=b"\x00"*8, rounds=8)
    return s20.encryptBytes(ciphertext)


def _salsa_encrypt(plaintext, dict_key):
    assert(type(dict_key) == bytes)
    assert(type(plaintext) == bytes)
    encrypt_key = ripemd128(dict_key)
    s20 = Salsa20(key=encrypt_key, IV=b"\x00"*8, rounds=8)
    return s20.encryptBytes(plaintext)


def _mdx_compress(data, compression_type=2):
    # depending on python version, zlib.adler32 may return a signed number.
    header = (pack(b"<L", compression_type) +
              pack(b">L", zlib.adler32(data) & 0xffffffff))
    if compression_type == 0:  # no compression
        return header + data
    elif compression_type == 2:
        return header + zlib.compress(data)
    else:
        raise ValueError("Unknown compression type")


def encrypt_key(dict_key, **kwargs):
    """
    Generates a hexadecimal key for use with the official MDict program.

    Parameters:
      dict_key: a bytes object, representing the dictionary password.

    Keyword parameters:
      Exactly one of email and device_id should be specified. They should be unicode strings,
      representing either the user's email address, or the device ID of the machine on which
      the dictionary is to be opened.

    Return value:
      a string of 32 hexadecimal digits. This should be placed in a file of its own,
      with the same name and location as the mdx file but the extension changed to '.key'.

    Example usage:
            key = encrypt_key(b"password", email="username@example.com")

            key = encrypt_key(b"password", device_id="12345678-9012-3456-7890-1234")
    """

    if(("email" not in kwargs and "device_id" not in kwargs) or ("email" in kwargs and "device_id" in kwargs)):
        raise ValueError(
            "Expected exactly one of email and device_id as keyword argument")

    if "email" in kwargs:
        owner_info_digest = ripemd128(kwargs["email"].encode("ascii"))
    else:
        owner_info_digest = ripemd128(kwargs["device_id"].encode("ascii"))

    dict_key_digest = ripemd128(dict_key)
    s20 = Salsa20(key=owner_info_digest, IV=b"\x00"*8, rounds=8)
    output_key = s20.encryptBytes(dict_key_digest)
    return "".join("{:02X}".format(ord(c)) for c in output_key)


def _unescape_entities(text):
    """
    unescape offending tags < > " &
    """
    text = text.replace(b'&lt;', b'<')
    text = text.replace(b'&gt;', b'>')
    text = text.replace(b'&quot;', b'"')
    text = text.replace(b'&amp;', b'&')
    return text
