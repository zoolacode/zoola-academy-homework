#!/bin/bash

$1

jq ".messages[].text" $1
