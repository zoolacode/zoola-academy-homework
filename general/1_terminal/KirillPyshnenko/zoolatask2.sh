#!/bin/sh

Day=$(date +"%d")
Today=$(date +"%u")
Friday=5
if [ "$Today" -gt "$Friday" ];then 
    echo "Cегодня $Day.Это, к счастью, Выходной, иди давить диванчик." 
else
    echo "Сегодня $Day.Это рабочий день, страдай." 
fi 

