#!/bin/sh

week_day=$(date +%u)
month_day=$(date +%d)

if [[ $week_day -ge 5 ]];
then
	echo "Looks like" "$month_day" "is a weekend"
else
	echo "Looks like" "$month_day" "is a working day"
fi
