#!/bin/bash

PATTERN="*.txt"
KEEP=9

function clean-outdate-files () {
    COUNT=0
    for file in `ls -t $1`; do
        (( COUNT++ ))
        if [ $COUNT -gt $2 ]; then
            rm -f $file
        fi
    done
}

clean-outdate-files "*.txt" "9"