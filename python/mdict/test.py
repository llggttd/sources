
from io import FileIO
import struct
import zlib

BYTE_ORDER_NATIVE = "="
BYTE_ORDER_LITTLE_ENDIAN = "<"
BYTE_ORDER_BIG_ENDIAN = ">"

DEFAULT_UNCODING = "UTF-8"


class DataDefine:

    def __init__(self, version='2.0'):
        pass

    def read(self, file: FileIO):
        raise NotImplementedError()

    def getData(self):
        raise NotImplementedError()


class FileHeaderDataDefine(DataDefine):

    def __init__(self):
        self._type = "QQQQQL"
        self._byteOrder = BYTE_ORDER_BIG_ENDIAN
        self._length = 44

    def read(self, file: FileIO):
        self._contentLength = struct.unpack('>L', file.read(4))[0]
        headerContent = file.read(self._contentLength)
        adler32 = struct.unpack('<L', file.read(4))[0]
        assert(adler32 == zlib.adler32(headerContent) & 0xffffffff)
        self._content = headerContent[:-6].decode('utf-16').encode('utf-8')

    def getData(self):
        return [self._contentLength, self._content]

    def getHeader(self):
        return self._content


class KeywardHeaderDataDefine(DataDefine):

    def __init__(self):
        self._type = "QQQQQL"
        self._byteOrder = BYTE_ORDER_BIG_ENDIAN
        self._length = 44

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

    def __init__(self, length):
        self._length = length

    def read(self, file: FileIO):
        indexData = file.read(self._length)

        # decompress
        key_block_info = zlib.decompress(indexData[8:])
        print(key_block_info)

        # adler checksum
        adler32 = struct.unpack('>I', indexData[4:8])[0]
        assert(adler32 == zlib.adler32(key_block_info) & 0xffffffff)
        i = 0
        print(len(key_block_info))
        while i < len(key_block_info):
            entriesNum = struct.unpack('>Q', key_block_info[i:i+8])[0]
            i += 8
            print('entries num = %s' % (entriesNum))

            firstKeyLength = struct.unpack('>H', key_block_info[i:i+2])[0]
            i += 2
            print('first key length = %s' % (firstKeyLength))
            firstKey = key_block_info[i:i+firstKeyLength]
            i += firstKeyLength + 1
            print('first key = %s' % (firstKey))

            lastKeyLength = struct.unpack('>H', key_block_info[i:i+2])[0]
            i += 2
            print('last key length = %s' % (lastKeyLength))
            lastKey = key_block_info[i:i+lastKeyLength]
            i += lastKeyLength + 1
            print('last key = %s' % (lastKey))
            print(' i ==== %s' % (i))

            compKeyBlocksSize = struct.unpack('>Q', key_block_info[i:i+8])[0]
            i += 8

            print('compKeyBlocksSize = %s' % (compKeyBlocksSize))
            deCompKeyBlocksSize = struct.unpack('>Q', key_block_info[i:i+8])[0]
            print('deCompKeyBlocksSize = %s' % (deCompKeyBlocksSize))
            i += 8

    def getData(self):
        return self._data


def load(filename):
    with open(filename, 'rb') as file:
        hdf = FileHeaderDataDefine()
        hdf.read(file)
        print(hdf.getData())

        kdf = KeywardHeaderDataDefine()
        kdf.read(file)
        print(kdf.getData())

        kid = KeywardIndexDataDefine(kdf.getIndexCompLength())
        kid.read(file)


DATA_FILE = 'D:\\mdict\\example_output\\basic.mdx'
# DATA_FILE = 'D:\\mdict\\牛津高阶8简体.mdx'
load(DATA_FILE)
