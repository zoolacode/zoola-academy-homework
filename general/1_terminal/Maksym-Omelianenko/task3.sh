#!/bin/sh

set -e

date=$(date +%d)
day=$(date +%u)

#it's for checking
#date=18
#day=6

if [ $day -eq 6 -o $day -eq 7 ]
then
    echo "Looks like $date is a weekend"
else
    echo "Looks like $date is a working day"
fi
