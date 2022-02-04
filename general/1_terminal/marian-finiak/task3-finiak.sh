#!/bin/bash

if [[ $(date +%u) -gt 5 ]]
  then
	echo "Looks like $(date +%d) is a weekend"
  else
	echo "Looks like $(date +%d) is a working day"
fi
