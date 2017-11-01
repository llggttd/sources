#!/bin/bash

BIN_PATH=""
BIN_NAME=""
BIN_LOG="run.log"
HAS_RUN=0
TICK=60

while true ; do
    if [ $HAS_RUN -gt 0 ]; then
        sleep $TICK
    fi
    HAS_RUN=1

    date >> $BIN_LOG
    # PRO_NOW=`ps aux | grep $BIN_NAME | grep -v grep | wc -l`
    # if [ $PRO_NOW -lt 1]; then
    #     $BIN_PATH/$BIN_NAME -p $PARAM_PORT -u $PARAM_USER 2>/dev/null 1>&2 &
    #     date >> $BIN_PATH/$BIN_LOG
    #     echo "Start $BIN_NAME" >> $BIN_PATH/$BIN_LOG
    # fi

    # PRO_STAT=`ps aux|grep $BIN_NAME |grep T|grep -v grep|wc -l`

    # if [ $PRO_STAT -gt 0 ] ; then
    #     killall -9 $BIN_NAME
    #     sleep 5
    #     $BIN_PATH/$BIN_NAME -p $PARAM_PORT -u $PARAM_USER 2>/dev/null 1>&2 &
    #     date >> $BIN_PATH/$BIN_LOG
    #     echo "Start $BIN_NAME" >> $BIN_PATH/$BIN_LOG
    # fi
done
exit 0