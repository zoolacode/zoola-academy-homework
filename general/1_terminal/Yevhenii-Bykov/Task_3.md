# Task 3

My script:
```sh
#!/bin/bash

day_of_week=$(date +%w) #assign the number of the day of the week
day_of_month=$(date +%e) #assign the number of the day of the month

if [ "$day_of_week" -lt 6 ] ; #chek that the day is less than the sixth (Saturday)
then echo -e 'Looks like' $day_of_month 'is a working day' ;
else echo -e 'Looks like' $day_of_month 'is a weekend' ;

fi
```
