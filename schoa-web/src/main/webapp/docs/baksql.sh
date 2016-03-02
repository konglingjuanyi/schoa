#/bin/sh
TODAY=$(date +%Y%m%d)
DELDAY=$(date -d '5 day ago' +%Y%m%d)
LOG=logs.sql.log

PREFIX=schoa_
TARGET=/bakup/database

sqlfile=${TARGET}/${PREFIX}${TODAY}.sql
delfile=${TARGET}/${PREFIX}${DELDAY}.sql

if [ ! -d $TARGET ];then
	mkdir $TARGET
fi

echo 'bakup sql to '${sqlfile} >> $LOG
#mysqldump -uroot -proot schoa > $sqlfile
touch $sqlfile
if [ ! -f $delfile ];then
	echo 'success' >> $LOG
else
	echo 'delete file '${delfile} >> $LOG
	rm $delfile
	echo 'success' >> $LOG
fi