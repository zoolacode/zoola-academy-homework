#!/usr/bin/zsh

a=`date +%u`
a=${a##0} # if number starts with 0 remove 0

if [[ $(date +%u) -ge 6 ]]; then
        echo "Looks like $a is working day"
else
        echo "Looks like $a is a weekend day"
fi

