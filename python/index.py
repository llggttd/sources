#!/usr/bin/python2
# -*- coding: UTF-8 -*-

import json
import os
import time


PATH = 'D:/Temp'
if os.path.exists(PATH):
    print 'file exist'
    stat = os.stat(PATH)
    print stat
    local = time.localtime(stat.st_ctime)
    print time.strftime("%Y-%m-%d %H:%M:%S", local) 
else:
    print 'file not exist'

