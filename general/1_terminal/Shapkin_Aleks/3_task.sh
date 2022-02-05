#!/bin/bash

current_day_num=$(date +%u)
date=$(date +%d)

if [[ $current_day_num -ge 6 ]]; then
 echo "looks like $date is a weekend "
else
 echo "Looks like $date is a working day"
fi
