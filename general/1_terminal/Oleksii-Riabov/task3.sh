#!/bin/sh

d=$( date "+%u" )
d2=$( date "+%e" )

if [ $d -gt 5 ]; then
 echo Looks like $d2 is a weekend
else
 echo Looks like $d2 is a working day
fi
