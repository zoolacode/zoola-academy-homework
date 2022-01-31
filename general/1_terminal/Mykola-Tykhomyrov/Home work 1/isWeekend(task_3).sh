#!/bin/bash

[[ `date +%u` -gt 5 ]] && day="weekend" || day="working day"

echo "Looks like $(date +%d) is a $day"
