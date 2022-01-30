#!/bin/zsh

# получаем месяц
month=`date +%B`
# получаем день месяца
day_of_month=`date +%d` 
# получаем день недели
day=`date +%u`

# прописываем условие для вывода текста
if [ $day -ge 6 ]; then
echo Похоже, что $day_of_month $month - выходной
else
echo Похоже, что $day_of_month $month - рабочий день
fi
