#!/bin/bash

# This scrpt is intended for print today's day of the month (as number), 
# and to comment: is it working day or weekend.

dayNumber=$(date +"%d")                                     # Mashine number of the day
printDayNumber=${dayNumber#"${dayNumber%%[!0]*}"}           # Removed leading zero from Mashine number

case $(date +"%u") in
    1) echo "Looks like ${printDayNumber} is a working day" # Monday
        ;;
    2) echo "Looks like ${printDayNumber} is a working day" # Tuesday
        ;;
    3) echo "Looks like ${printDayNumber} is a working day" # Wednesday
        ;;
    4) echo "Looks like ${printDayNumber} is a working day" # Thursday
        ;;
    5) echo "Looks like ${printDayNumber} is a working day" # Friday
        ;;
    6) echo "Looks like ${printDayNumber} is a weekend"     # Saturday
        ;;
    7) echo "Looks like ${printDayNumber} is a weekend"     # Sunday
        ;;
esac