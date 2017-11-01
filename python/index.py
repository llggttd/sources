#!/usr/bin/python
# -*- coding: UTF-8 -*-

'''
This is a test.
'''

import json
import os

DATA = {'name': 'lgt', 'pass': 123456}

print(json.dumps(DATA))

SRC = open('./index.py', 'r')

print(SRC.read())

SRC.close()
