#!/bin/bash

# This script is intended for create a bunch of files using touch. 
# Output the names of those that have zoola in their names.

qtyOfFiles=5                            # Set quantity of files that will be created

for (( i = 0; i < $qtyOfFiles; i++ ))   # Loop for creating each file
do
    touch "Zoola-$i.txt"
done

ls -l | grep Zoola                      # Output files where "Zoola" word is present in the filename

for (( i = 0; i < $qtyOfFiles; i++ ))   # Loop for deleting each created Zoola- file
do
    rm "Zoola-$i.txt"
done