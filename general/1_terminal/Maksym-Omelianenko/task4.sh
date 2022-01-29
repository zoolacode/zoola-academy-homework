#!/bin/sh

set -e

jq '.messages | .[] | .text' result.json
