#!/usr/bin/zsh

jq '.messages[] | .text | if type == "array" then [.[] | if type == "object" then .text else . end] | add else . end | select(length > 0)' ./task-4.json
