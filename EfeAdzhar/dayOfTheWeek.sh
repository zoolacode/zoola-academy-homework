#!/bin/zsh
dayOfMonth=$(date +%d)
dayOfTheWeek=$(date +%u)
dayOfTheWeekName=$(date +%A)

if (($dayOfTheWeek <= 5));
then
   echo "Look like $dayOfMonth which is $dayOfTheWeekName is a working day"
else
   echo "Looks like $dayOfMonth which is $dayOfTheWeekName is a weekend"
fi
