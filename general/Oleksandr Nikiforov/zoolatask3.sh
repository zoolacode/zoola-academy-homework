#!/bin/bash
now=$(date +'%d')
if [[ $(date +%u) -gt 5 ]]; then
    printf 'Looks like %s is a weekend.\n' "$now"
else
   printf  'Looks like %s is a working day. \n' "$now"
fi
