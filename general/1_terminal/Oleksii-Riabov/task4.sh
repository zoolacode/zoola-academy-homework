#!/bin/sh

cat $1 | jq -r '.messages[] | "\(.text)"'
