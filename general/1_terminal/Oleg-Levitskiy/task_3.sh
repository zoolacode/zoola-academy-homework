#!/bin/bash

day_week=$(date +%u)
day_month=$(date +%d)
weekend='6 7'

if grep -q "$day_week" <<< "$weekend"
then
  echo Looks like $day_month is a weekend
else
  echo Looks like $day_month is a working day
fi
