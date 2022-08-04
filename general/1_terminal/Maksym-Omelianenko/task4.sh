#!/bin/sh

set -ex

jq '.messages | .[] | .text | select(type != "array" and . != "")' result.json
