#!/bin/bash



jq '.messages[]' result.json | jq '.text' 