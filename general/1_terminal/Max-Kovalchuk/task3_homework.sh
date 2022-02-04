#!/bin/zsh

# get month
month=`date +%B`
# get day of month
day_of_month=`date +%d` 
# get day of week
day_of_week=`date +%u`

# condition for text output
if [ $day_of_week -ge 6 ]; then
echo Looks like $day_of_month $month - weekend
else
echo Looks like $day_of_month $month - work day
fi
