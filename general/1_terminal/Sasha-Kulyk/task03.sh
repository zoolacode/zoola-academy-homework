#!/bin/sh


dayWeek=$(date '+%u')
dayNumber=$(date '+%d')

if [ $dayNumber -gt 5  ]
then
        echo "Looks like $dayNumber is a weekend"
else
        echo "Looks like $dayNumber is a working day"
fi
