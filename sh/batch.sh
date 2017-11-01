#!/bin/bash

# 批量执行命令
function work() {
	ping -c 1 $1
}

for ((i=1;i<4;i++)); do
	for ((j=1;j<256;j++)); do
		work "192.168.$i.$j"
	done
done