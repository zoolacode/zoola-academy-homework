#!/bin/sh

massages=$(jq '.messages[].text' json.json)
echo "$massages"


