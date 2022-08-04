#!/bin/bash
currentDay="$(date "+%u")"
currentNumber="$(date "+%d")"
if [[ "$currentDay">5 ]]; then
        echo "Looks like ${currentNumber} is a weekend."
else 
        echo "Looks like ${currentNumber} is a working day."
fi

