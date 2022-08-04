The cd affect only the sub-shell running the script, not the interactive current shell. 
One of solutions is to use the source command, which execute commands from a file in the current shell.

source ./mcd.sh nested/dir or . ./mcd.sh nested/dir.