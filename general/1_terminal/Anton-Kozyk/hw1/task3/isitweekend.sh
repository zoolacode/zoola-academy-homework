#!/bin/bash

day=$(date +%a)

if [ $day == "Сб" ] || [ $day="Вс" ]; then
  sowhat="weekend"
else
  sowhat="working day"
fi

echo "Looks like $(date +%d) is a $sowhat"
