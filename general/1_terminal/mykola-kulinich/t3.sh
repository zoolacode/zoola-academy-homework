#!/bin/zsh

current_week_day=$(date '+%u')
current_day_number=$(date '+%d')

if [ $current_week_day -gt 5  ]
then
        echo "Looks like $current_day_number is a weekend"
else
        echo "Looks like $current_day_number is a working day"
fi

