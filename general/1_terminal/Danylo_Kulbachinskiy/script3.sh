#!/bin/bash
f="$(date "+%d")"
arr=("субота" "неділя")

for i in $arr; do
    if [[ i == *"$date "+%A""* ]]
    then
        echo "Looks like "${f}" is a weekend."
    else
        echo "Looks like "${f}" is a working day"
    fi
done
