#!/bin/sh

cat zoola_chat_result.json | jq .messages[].text
