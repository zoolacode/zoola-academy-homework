1 task:

ls -l | grep zoola

2 task:

Because it start in new session.
if you need to change working directory, then you need to:
source mcd.sh

3 task:

in a file: 3_task.sh

#!/bin/bash

current_day_num=$(date +%u)
date=$(date +%d)

if [[ $current_day_num -ge 6 ]];
then
 echo "looks like $date is a weekend"
else
 echo "Looks like $date is a working day"
fi

4 task:

cat result.json | jq '.messages[].text'
cat result.json | ./4_task.sh

in a file: 4_task.sh

#!/bin/zsh

jq '.messages[].text'

