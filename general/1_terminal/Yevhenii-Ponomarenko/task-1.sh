#!/usr/bin/zsh

# Create test files for the task
touch "test"
touch "zoolatest"
touch "touch"
touch "zoolatech"
touch "plausible"
touch "somethingzoola"
touch "somezoolathing"
touch "zoom"

# Find and write to stdout filenames that have "zoola" in their names
for i in $(ls); do
	if echo $i | grep -q zoola -; then
		echo $i
	fi
done

# Cleanup
rm plausible some* test touch zoo*
