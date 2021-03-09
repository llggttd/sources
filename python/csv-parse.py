import csv
import string
from colorama import Back, Fore, Style

DATA_FILE = 'D:\\Temp\\test-data-small.csv'


def load(filepath):
    '''加载csv文件内容

    以第一行内容为键名，把每一行内容转换成对象，返回数据结构如下：
    [
        {'key1': 'val1'},
        {'key2': 'val2'}
    ]

    '''
    with open(filepath) as file:
        rows = csv.reader(file)
        header = next(rows)
        result = []
        for row in rows:
            item = {head: None for head in header}
            for index, key in enumerate(header):
                item[key] = row[index]
            result.append(item)
        return result


TEMPLATE = "INSERT INTO `pricing`.`pricing_partner_rate_product`(`product_no`, `fund_channel_code`, `partner_no`, `coop_no`, `coop_name`, `rate_product_seq`, `rate_product_code`, `rate_product_desc`, `period`, `saler_code`, `saler_name`, `saler_mobile`, `doc_channel`, `memo`, `status`, `gmt_create`, `gmt_modified`) VALUES ('$productNo', $fundChannelCode, '$partnerNo', '$coopNo', '$coopName', '$rateProductSeq', '$rateProductCode', '$rateProductDesc', NULL, 'MP000004464', '丽人贷总权限', '13738051514', 'DOClist026', NULL, 1, NOW(), NOW());"

template = string.Template(TEMPLATE)

for record in load(DATA_FILE):
    sql = template.substitute(
        productNo='P1024',
        fundChannelCode=17,
        partnerNo=record['ID'],
        coopNo=record['ID'],
        coopName=record['DATA'],
        rateProductSeq=record['DATA'],
        rateProductCode=record['DATA'],
        rateProductDesc=record['DATA']
    )
    print(Fore.GREEN + sql)
