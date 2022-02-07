#!/bin/sh


DOM=$(date +"%d")

DOW=$(date +"%u")

if [[ $DOW == 6 || $DOW == 7 ]]

then echo "Looks like $DOM is a weekend"

else echo "Looks like $DOM is a working day" 

fi
