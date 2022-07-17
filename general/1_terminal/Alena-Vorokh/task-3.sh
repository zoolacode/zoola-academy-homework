#Task-3
#!/bin/bash
day="$(date "+%u")"
number="$(date "+%d")"
if [[ "$day" > 5 ]]; then
        echo "Looks like ${number} is a weekend."
else 
        echo "Looks like ${number} is a working day."
fi

