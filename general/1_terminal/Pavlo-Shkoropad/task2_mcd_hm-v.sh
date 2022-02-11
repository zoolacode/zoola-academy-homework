#!/bin/bash

mkdir -p $1 
cd $1
touch test.txt
echo "mkdir -p $1"
echo "cd $1"
pwd
echo $$
echo "touch test.txt"


ret=$?; times; exit "$ret"

