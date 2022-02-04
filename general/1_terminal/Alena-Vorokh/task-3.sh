#Task-3
#!/bin/bash
day="$(date "+%A")"
number="$(date "+%d")"
if [[ "$day" == "$Saturday" || "$day" == "$Sunday" ]]; then
        echo "Looks like ${number} is a weekend."
else 
        echo "Looks like ${number} is a working day."
fi

