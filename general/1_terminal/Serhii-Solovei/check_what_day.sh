#!/bin/bash

NumberOfDay=$(date +%u)
NameOfMonth=$(date +%B)
NumberOfDate=$(date +%d)


if [ "$NumberOfDay" -gt 0 ] && [ "$NumberOfDay" -lt 6 ]

then echo "Looks like "$NumberOfDate" of "$NameOfMonth" is a working day" 

else echo "Looks like "$NumberOfDate" of "$NameOfMonth" is a weekend"

fi
