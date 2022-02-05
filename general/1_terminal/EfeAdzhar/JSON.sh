#!/bin/zsh
JSON=$(cat ./Downloads/result.json | jq -r '.messages[] | [.text]')
echo $JSON | tr '\r\n' ' ' | jq .
