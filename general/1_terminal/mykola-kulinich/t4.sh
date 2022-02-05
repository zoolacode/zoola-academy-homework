#!/bin/zsh

jq '.messages[] | .text' $1 > t4.txt 

