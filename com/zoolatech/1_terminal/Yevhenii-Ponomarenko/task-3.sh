#!/usr/bin/zsh

if [[ $(date +%u) -ge 6 ]]; then
	STATE="weekend"
else
	STATE="working day"
fi

echo "Looks like `date +%d` is a $STATE."
