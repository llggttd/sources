#!/bin/bash

PROG_PATH=""
PROG_NAME=""
PROD_LOG="run.log"
RUN=0
TICK=60

function run-prog () {
    $PROG_PATH/$PROG_NAME -p 12345 -u ZZJR 2>/dev/null 1>&2 &
}

while true; do
    if [ $RUN -gt 0 ]; then
        sleep $TICK
        RUN=0
    fi
    RUN=1
    if [ `ps aux | grep $PROG_NAME | grep -v grep | wc -l` -lt 1 ]; then
        run-prog
        echo `date +%Y%m%d %H%M%S` >> $PROG_PATH/$PROD_LOG
        echo "start $PROG_NAME success." >> $PROG_PATH/$PROD_LOG
    fi
done
exit 0