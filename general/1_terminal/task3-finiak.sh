#!/bin/bash

read -p  'enter text: ' name

day=$(echo $name | awk '{print $NF}')
NUMBER=$(echo $name | tr -dc '0-9')

if [ $day == 'Sunday' ] || [ $day == 'Saturday' ] || [ $day == 'Неділя' ] || [ $day == 'Субота' ] || [ $day == 'Воскресенье' ] || [ $day == 'Суббота' ] || [ $day == 'रविवार' ] || [ $day == 'शनिवार' ]
then 
	echo "Looks like $NUMBER is a weekend day" 
elif [ $day == 'Monday' ] || [ $day == 'Tuesday' ] || [ $day == 'Wednesday' ] || [ $day == 'Thursday' ] || [ $day == 'Friday' ] || [ $day == 'Понеділок' ] || [ $day == 'Вівторок' ] || [ $day == 'Середа' ] || [ $day == 'Четвер' ] || [ $day == "П'ятниця" ] || [ $day == 'Понедельник' ] || [ $day == 'Вторник' ] || [ $day == 'Среда' ] || [ $day == 'Четверг' ] || [ $day == 'Пятница' ] || [ $day == 'सोमवार' ] || [ $day == 'मंगलवार' ] || [ $day == 'बुधवार' ] || [ $day == 'गुरूवार' ] || [ $day == 'शुक्रवार' ]
then
	echo "Looks like $NUMBER is a working day"
else
	echo "Sorry the line you entered is incorrect"
fi
