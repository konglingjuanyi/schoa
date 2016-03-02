#/bin/sh
TODAY=$(date +%Y%m%d)
DELDAY=$(date -d '5 day ago' +%Y%m%d)
LOG=logs.img.log

SOURCE=/opt/schoa-res/res
TARGET=/bakup/res

targetFolder=$TARGET/$TODAY
delFolder=$TARGET/$DELDAY

if [ ! -d $TARGET ];then
	mkdir $TARGET
fi

echo 'bakup img to folder '${targetFolder} >> $LOG
mkdir $targetFolder
cp -r $SOURCE/* $targetFolder/
if [ ! -d $delFolder ];then
	echo 'success' >> $LOG
else
	echo 'delete img folder '${delFolder} >> $LOG
	rm -rf $delFolder
	echo 'success' >> $LOG
fi