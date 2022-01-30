#!/bin/sh

touch someFile.txt secondSomeFile.txt zoolaSomeFile.txt \
 names.txt  XXzoolaxx.txt

ls -a | grep "zoola"
