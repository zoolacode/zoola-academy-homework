#!/bin/bash
name=$1
name1=${name%%th}
case $3 in
    "January") month="01";;
    "February") month="02";;
    "March") month="03";;
    "April") month="04";;
    "May") month="05";;
    "June") month="06";;
    "July") month="07";;
    "August") month="08";;
    "September") mont="09";;
    "October") month=10;;
    "November") month=11;;
    "December") month=12;;
    *) month="error";;
esac

day=`date -d 2022-$month-$name1 +%A`

if [[ "понеділок вівторок середа четвер п'ятниця" == *$day* ]]; then
    day="working"
elif [[ "субота неділя" == *$day* ]]; then
    day="weekend"
else
    day="error"
fi

echo "Looks likes $name1 is $day day"