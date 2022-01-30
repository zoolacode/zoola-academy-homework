#!/bin/bash



jq '.messages[]' result.json | jq '.text' | tr -d 'a-z',"A-Z",'/"[]{}:\.','-_','&#'