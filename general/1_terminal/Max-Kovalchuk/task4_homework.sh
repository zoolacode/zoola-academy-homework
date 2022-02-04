#!/bin/bash

jq '.messages | .[].text | if type == "string" then . else .[] end' $1
