#!/bin/bash
f="$(date "+%d")"
day="$(date "+%u")"
if [[  $day == 6  || $day == 7  ]]; then
    echo "Looks like "${f}" is a weekend."
else
    echo "Looks like "${f}" is a working day"
fi

