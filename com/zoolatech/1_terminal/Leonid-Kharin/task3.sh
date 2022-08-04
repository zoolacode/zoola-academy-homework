#!/usr/bin/zsh

a=`date +%u`
a=${a##0} # if number starts with 0 remove 0

if [[ $(date +%u) -gt 5 ]]; then
        echo "Looks like $a is weekend day"
else
        echo "Looks like $a is a working day"
fi

