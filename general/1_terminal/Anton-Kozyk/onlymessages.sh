#!/bin/bash

jq '.messages[].text | if type=="string" then . else [.[] | if type=="object" then .text else . end] | add  end | select(length>0)' $1
