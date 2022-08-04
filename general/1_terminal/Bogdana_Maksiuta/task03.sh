
#!/bin/bash

USER_DATE=$(date '+%d %B %Y') #To get today's date in format year-month-day

CURDAY=$(date +%u) #To change today's date in the format Number of weekdays

if [ $CURDAY -lt 6 ] #If number today's number weekday is less than 6, than
then
        echo "Looks like" $USER_DATE "is a working day"

else
        echo "Looks like" $USER_DATE "is a weekend"

fi
