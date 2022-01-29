#!/bin/zsh
dayOfMonth=$(date +%d)
dayOfTheWeek=$(date +%u)
dayOfTheWeekName=$(date +%A)

if (($dayOfTheWeek >= 1 && $dayOfTheWeek <= 5));
then
   echo "Look like $dayOfMonth which is $dayOfTheWeekName is a working day"

elif (($dayOfTheWeek = 6)) || (( $dayOfTheWeek = 7));
then
   echo "Looks like $dayOfMonth which is $dayOfTheWeekName is a working day"
else
   echo "ERROR" 
fi
