#!bin/bash

jq '.messages[]' result.json | '.text'
