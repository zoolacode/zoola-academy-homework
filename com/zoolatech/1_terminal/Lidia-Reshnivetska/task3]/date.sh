#!/bin/bash

echo "Today's date is: $(date)"
day=$(date +%u)

if ((day > 5)); then
   echo "WEEKEND"        
else
   echo "WORKING DAY"
fi
