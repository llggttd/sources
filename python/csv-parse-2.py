import csv

DATA_FILE = 'D:\\Temp\\test-data-small.csv'

def load(filepath):
    with open(filepath) as file:
        rows = csv.reader(file)
        header = next(rows)
        print(header)
        for row in rows:
            print(row)
        return rows


load(DATA_FILE)
