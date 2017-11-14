#!/bin/bash

cp /opt/zbox/app/api/Sqlite/showdoc.db.php /var/data/showdoc/$(date '+%F')-showdoc.db.php
tar -czvf showdoc.uploads.tar.gz /opt/zbox/app/api/Public/Uploads/
mv showdoc.uploads.tar.gz /var/data/showdoc/$(date '+%F')-showdoc.uploads.tar.gz
rsync -vrztp /opt/zbox/app/zentao/tmp/backup/ /var/data/zentao/


function clean-outdate-files () {
    COUNT=0
    for file in `ls -t $1`; do
        (( COUNT++ ))
        if [ $COUNT -gt $2 ]; then
            rm -f $file
        fi
    done
}

cd /var/data/showdoc/
clean-outdate-files "*-showdoc.db.php" "7"
clean-outdate-files "*-showdoc.uploads.tar.gz" "7"

cd /var/data/zentao/
clean-outdate-files "*.file.zip.php" "7"
clean-outdate-files "*.code.zip.php" "7"
clean-outdate-files "*.sql.php" "7"
