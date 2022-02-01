#!/bin/zsh

readonly LAST_WORK_DAY_OF_WEEK=5

day=$(date +"%d")
order=$(date +"%u")

if [[ "$order" -le LAST_WORK_DAY_OF_WEEK ]]; then
  echo "Looks like $day is a working day"
else
  echo "Looks like $day is a weekend"
fi
