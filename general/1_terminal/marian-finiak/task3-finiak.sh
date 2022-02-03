#!/bin/bash

read -p  'enter text: ' name

NUMBER=$(echo $name | tr -dc '0-9')

if [[ $(date +%u) -gt 5 ]];
then 
	echo "Looks like $NUMBER is a weekend day" 
else
	echo "Looks like $NUMBER is a working day"
fi
