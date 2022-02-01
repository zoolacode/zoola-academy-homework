#!/bin/bash

read -p  'enter text: ' name

day=$(echo $name | awk '{print $NF}')
NUMBER=$(echo $name | tr -dc '0-9')

if [ $day == 'Sunday' ] || [ $day == 'Saturday' ]
then 
	echo "Looks like $NUMBER is a weekend day" 
elif [ $day == 'Monday' ] || [ $day == 'Tuesday' ] || [ $day == 'Wednesday' ] || [ $day == 'Thursday' ] || [ $day == 'Friday' ]  
then
	echo "Looks like $NUMBER is a working day"
else
	echo "Sorry the line you entered is incorrect"
fi
