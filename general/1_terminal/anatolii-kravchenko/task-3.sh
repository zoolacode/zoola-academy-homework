#!/bin/bash

# This scrpt is intended for print today's day of the month (as number), 
# and to comment: is it working day or weekend.

dayNumber=$(date +"%d")                                     # Mashine number of the day
printDayNumber=${dayNumber#"${dayNumber%%[!0]*}"}           # Removed leading zero from Mashine number

if [[ $(date +"%u") -lt 6 ]]; then
    echo "Looks like ${printDayNumber} is a working day"
else
    echo "Looks like ${printDayNumber} is a weekend"
fi