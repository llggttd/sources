# -*- coding: UTF-8 -*-
import socket
import fcntl
import struct
import os
import time

def get_ip_address(ifname):
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    return socket.inet_ntoa(fcntl.ioctl(
        s.fileno(),
        0x8915,  # SIOCGIFADDR
        struct.pack('256s', ifname[:15])
    )[20:24])

def get_file_ctime(path):
    if os.path.exists(path):
        local = time.localtime(os.stat(path).st_ctime)
        return time.strftime("%Y-%m-%d %H:%M:%S", local)
    return None

TOMCAT = '/usr/local/tomcat/webapps/ROOT'
print('')
print('本机地址:       %s'%(get_ip_address('eth0')))
tomcat_deploy_time = get_file_ctime(TOMCAT)
if tomcat_deploy_time:    
    print(Tomcat发布时间: %s'%(tomcat_deploy_time))
print('')
