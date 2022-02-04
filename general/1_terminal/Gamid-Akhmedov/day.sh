#!/bin/bash

day=`date +%a | tr '[:lower:]' '[:upper:]'`
dayFull=`date +%D`

if [ $day = "SAT" -o $day = "SUN" ]
then 
    echo "Looks like ${dayFull} is a weekend"
else
    echo "Looks like ${dayFull} is a working day"
fi
