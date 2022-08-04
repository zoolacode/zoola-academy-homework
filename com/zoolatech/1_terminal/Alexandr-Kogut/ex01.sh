#!/bin/zsh

readonly STRING=zoola

echo $(ls | grep $STRING)
