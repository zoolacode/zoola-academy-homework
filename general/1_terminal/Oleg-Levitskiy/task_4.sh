#!/bin/sh

jq '.messages[].text | if(type == "array") then .[0] else . end' ${1}
