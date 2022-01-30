#!/bin/bash

today=$(date '+%a')
if [ $today == 'Сб' ] || [ $today == 'Вс' ] || [ $today == 'Sat' ] || [ $today == 'Sun' ]
	then echo "looks like $(date +%d) is a weekend day"
else
	 echo "looks like $(date +%d) is a working day"
fi

