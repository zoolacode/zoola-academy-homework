#!/bin/sh


DOM=$(date +"%d")

LANG=C DOW=$(date +"%a")

if [[ $DOW == "Sat" || $DOW == "Sun" ]]

then echo "Looks like $DOM is a weekend"

else echo "Looks like $DOM is a working day" 

fi
