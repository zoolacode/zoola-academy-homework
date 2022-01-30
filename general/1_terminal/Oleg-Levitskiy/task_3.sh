#!/bin/bash

todays_date=$(date +"%y-%m-%d")
day_week=$(date -d $todays_date +%A)
day_month=$(date +%d)
weekend='Saturday Sunday'

if grep -q "$day_week" <<< "$weekend"
then
  echo Looks like $day_month is a weekend
else
  echo Looks like $day_month is a working day
fi
