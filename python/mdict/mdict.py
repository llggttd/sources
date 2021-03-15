
from io import FileIO
import struct
import zlib
import util

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
        self._contentLength = struct.unpack('>L', file.read(4))[0]
        headerContent = file.read(self._contentLength)
        adler32 = struct.unpack('<L', file.read(4))[0]
        assert(adler32 == zlib.adler32(headerContent) & 0xffffffff)
        self._content = headerContent[:-
                                      6].decode('utf-16').encode(DEFAULT_ENCODING)

    def getData(self):
        return [self._contentLength, self._content]

    def getHeader(self):
        return self._content


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

    def __init__(self, length):
        super().__init__()
        self._length = length

    def read(self, file: FileIO):
        keywardIndexData = file.read(self._length)
        keywardBlockInfo = zlib.decompress(
            util._mdx_decrypt(keywardIndexData)[8:])
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
            
            firstKey = keywardBlockInfo[i:i+firstKeyLength].encode(DEFAULT_ENCODING)
            i += firstKeyLength + text_term

            lastKeyLength = struct.unpack(byte_format, keywardBlockInfo[i:i+byte_width])[0]
            i += byte_width
            lastKey = keywardBlockInfo[i:i +
                                       lastKeyLength].encode(DEFAULT_ENCODING)
            i += lastKeyLength + text_term

            compKeyBlocksSize = struct.unpack(
                '>Q', keywardBlockInfo[i:i+BYTE_LENGTH_NUMBER])[0]
            i += BYTE_LENGTH_NUMBER

            deCompKeyBlocksSize = struct.unpack(
                '>Q', keywardBlockInfo[i:i+BYTE_LENGTH_NUMBER])[0]
            i += BYTE_LENGTH_NUMBER
            keyIndex.append({
                'entries_number': entriesNum,
                'first_keyword': firstKey,
                'last_keyward': lastKey,
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
        keywardIndexData = file.read(self._length)
        keywardBlockInfo = zlib.decompress(
            util._mdx_decrypt(keywardIndexData)[8:])
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
            
            firstKey = keywardBlockInfo[i:i+firstKeyLength]
            i += firstKeyLength + text_term

            lastKeyLength = struct.unpack(byte_format, keywardBlockInfo[i:i+byte_width])[0]
            i += byte_width
            lastKey = keywardBlockInfo[i:i+lastKeyLength]
            i += lastKeyLength + text_term

            compKeyBlocksSize = struct.unpack(
                '>Q', keywardBlockInfo[i:i+BYTE_LENGTH_NUMBER])[0]
            i += BYTE_LENGTH_NUMBER

            deCompKeyBlocksSize = struct.unpack(
                '>Q', keywardBlockInfo[i:i+BYTE_LENGTH_NUMBER])[0]
            i += BYTE_LENGTH_NUMBER
            keyIndex.append({
                'entries_number': entriesNum,
                'first_keyword': firstKey,
                'last_keyward': lastKey,
                'compress_key_blocks_size': compKeyBlocksSize,
                'decompress_key_blocks_size': deCompKeyBlocksSize
            })
            self._data = keyIndex

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
        print(kid.getData())

# DATA_FILE = 'D:\\mdict\\example_output\\basic.mdx'
DATA_FILE = 'D:\\mdict\\牛津高阶8简体.mdx'
load(DATA_FILE)
