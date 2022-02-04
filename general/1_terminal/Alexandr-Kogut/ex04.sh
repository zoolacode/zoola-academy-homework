#!/bin/zsh

cat $1 | jq '.messages | .[] | .text'
