
from io import FileIO
import struct
import zlib
import util
import os
from xml.dom.minidom import parseString

DEFAULT_ENCODING = "UTF-8"

BYTE_LENGTH_NUMBER = 8
BYTE_LENGTH_WORD = 2


class DataDefine:

    def __init__(self, version='2.0', encoding=DEFAULT_ENCODING):
        self._version = version
        self._encoding = encoding

    def read(self, file: FileIO):
        raise NotImplementedError()

    def getData(self):
        raise NotImplementedError()


class FileHeaderDataDefine(DataDefine):

    def __init__(self):
        super().__init__()

    def read(self, file: FileIO):
        length = struct.unpack('>L', file.read(4))[0]
        header = file.read(length)
        adler32 = struct.unpack('<L', file.read(4))[0]
        assert(adler32 == zlib.adler32(header) & 0xffffffff)
        self._data = header[:-6].decode('utf-16').encode(self._encoding)

    def getData(self):
        return self._data


class KeywardHeaderDataDefine(DataDefine):

    def __init__(self):
        super().__init__()

    def read(self, file: FileIO):
        headerData = file.read(40)
        adler32 = struct.unpack('>L', file.read(4))[0]
        assert(adler32 == zlib.adler32(headerData) & 0xffffffff)
        self._data = struct.unpack('>QQQQQ', headerData)

    def getData(self):
        return self._data

    def getBlocksNum(self):
        return self._data[0]

    def getEntriesNum(self):
        return self._data[1]

    def getIndexDeCompLength(self):
        return self._data[2]

    def getIndexCompLength(self):
        return self._data[3]

    def getBlocksLength(self):
        return self._data[4]


class KeywardIndexDataDefine(DataDefine):

    def __init__(self, length, encrypt):
        super().__init__()
        self._length = length
        self._encrypt = encrypt

    def read(self, file: FileIO):
        keywardIndexData = file.read(self._length)
        if self._encrypt & 0x02:
            keywardIndexData = util._mdx_decrypt(keywardIndexData)
        keywardBlockInfo = zlib.decompress(keywardIndexData[8:])
        adler32 = struct.unpack('>I', keywardIndexData[4:8])[0]
        assert(adler32 == zlib.adler32(keywardBlockInfo) & 0xffffffff)

        byte_format = '>H'
        byte_width = 2
        text_term = 1

        i = 0
        keyIndex = []
        while i < len(keywardBlockInfo):
            entriesNum = struct.unpack(
                '>Q', keywardBlockInfo[i:i+BYTE_LENGTH_NUMBER])[0]
            i += BYTE_LENGTH_NUMBER
            firstKeyLength = struct.unpack(
                byte_format, keywardBlockInfo[i:i+byte_width])[0]
            i += byte_width

            firstKey = str(
                keywardBlockInfo[i:i+firstKeyLength], encoding=DEFAULT_ENCODING)
            i += firstKeyLength + text_term

            lastKeyLength = struct.unpack(
                byte_format, keywardBlockInfo[i:i+byte_width])[0]
            i += byte_width
            lastKey = str(
                keywardBlockInfo[i:i + lastKeyLength], encoding=DEFAULT_ENCODING)
            i += lastKeyLength + text_term

            compKeyBlocksSize = struct.unpack(
                '>Q', keywardBlockInfo[i:i+BYTE_LENGTH_NUMBER])[0]
            i += BYTE_LENGTH_NUMBER

            deCompKeyBlocksSize = struct.unpack(
                '>Q', keywardBlockInfo[i:i+BYTE_LENGTH_NUMBER])[0]
            i += BYTE_LENGTH_NUMBER
            keyIndex.append({
                'entries_number': entriesNum,
                'first_keyward': firstKey,
                'first_keyward_length': firstKeyLength,
                'last_keyward': lastKey,
                'last_keyward_length': lastKeyLength,
                'compress_key_blocks_size': compKeyBlocksSize,
                'decompress_key_blocks_size': deCompKeyBlocksSize
            })
            self._data = keyIndex

    def getData(self):
        return self._data


class KeywardBlockDataDefine(DataDefine):

    def __init__(self, length):
        super().__init__()
        self._length = length

    def read(self, file: FileIO):
        keywardBlockData = zlib.decompress(file.read(self._length)[8:])
        key_list = []
        key_start_index = 0
        while key_start_index < len(keywardBlockData):
            # the corresponding record's offset in record block
            key_id = struct.unpack(
                '>Q', keywardBlockData[key_start_index:key_start_index+BYTE_LENGTH_NUMBER])[0]
            delimiter = b'\x00'
            width = 1
            i = key_start_index + BYTE_LENGTH_NUMBER
            while i < len(keywardBlockData):
                if keywardBlockData[i:i+width] == delimiter:
                    key_end_index = i
                    break
                i += width
            key_text = str(
                keywardBlockData[key_start_index+BYTE_LENGTH_NUMBER:key_end_index], encoding=DEFAULT_ENCODING).strip()
            key_start_index = key_end_index + width
            key_list += [(key_id, key_text)]
        self._data = key_list

    def getData(self):
        return self._data


class Mdict:
    def __init__(self, filepath):
        self._filepath = filepath
        self.__parse()

    def getHeader(self, key=None):
        element = parseString(self._fileheader).documentElement
        if key is None:
            return element.attributes.items()
        return element.getAttribute(key)

    def __parse(self):
        with open(self._filepath, 'rb') as file:
            hdf = FileHeaderDataDefine()
            hdf.read(file)
            self._fileheader = hdf.getData()
            self._encrypt = int(self.getHeader('Encrypted'))
            kdf = KeywardHeaderDataDefine()
            kdf.read(file)
            self._entriesNum = kdf.getEntriesNum()
            self._blocksNum = kdf.getBlocksNum()

            kid = KeywardIndexDataDefine(kdf.getIndexCompLength(), self._encrypt)
            kid.read(file)
            self._keywardIndex = kid.getData()

            for i in range(self._blocksNum):
                kbd = KeywardBlockDataDefine(
                    self._keywardIndex[i]['compress_key_blocks_size'])
                kbd.read(file)
                print(kbd.getData())

    def getFileInfo(self):
        pass


BASE_PATH = os.path.dirname(__file__)
# DATA_FILE = os.path.join(BASE_PATH, '牛津高阶8简体.mdx')
DATA_FILE = os.path.join(BASE_PATH, 'example_output/basic.mdx')

mdict = Mdict(DATA_FILE)
# print(mdict.getHeader())
