#!/bin/sh

WEEKDAY=$( date "+%u" )
DAY_OF_THE_MONTH=$( date "+%e" )
FRIDAY=5

if [ $WEEKDAY -gt $FRIDAY ]; then
 echo Looks like $DAY_OF_THE_MONTH is a weekend
else
 echo Looks like $DAY_OF_THE_MONTH is a working day
fi
