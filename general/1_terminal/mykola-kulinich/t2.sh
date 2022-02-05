#!/bin/zsh

echo "question: The nested directory is created, but the working directory didn't change. Why?"
echo "answer: The script is run in a subshell, and cannot change the parent shell working directory. Its effects are lost when it finishes."
echo "solution: you should run ->  source ./mcd.sh nested/dir"

mkdir -p $1
cd ./$1
