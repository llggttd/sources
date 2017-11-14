#!/bin/bash

PROG_PATH="/opt/idea"
PROG_NAME="idea-license-server"
PROD_LOG="run.log"
RUN=0
TICK=600

function run-prog () {
    $PROG_PATH/$PROG_NAME -p 12345 -u ZZJR 2>/dev/null 1>&2 &
}

while true; do
    if [ $RUN -gt 0 ]; then
        sleep $TICK
        RUN=0
    fi
    RUN=1
    echo "`date '+%Y-%m-%d %H:%M:%S'` -- check status" >> $PROG_PATH/$PROD_LOG
    if [ `ps aux | grep $PROG_NAME | grep -v grep | wc -l` -lt 1 ]; then
        run-prog
        echo "`date '+%Y-%m-%d %H:%M:%S'` -- start $PROG_NAME success." >> $PROG_PATH/$PROD_LOG
    fi
done
exit 0
