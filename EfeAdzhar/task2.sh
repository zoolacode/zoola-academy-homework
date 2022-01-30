#!/bin/zsh
mkdir -p $1
cd $1

#ANSWEAR:CD command works, but only inside the script because we launching it in a subprocess.
#Which means, when execution ends, the subprocess will be destroyed, we will be on the current process.
#To fix the issue, you have to launch it on the current process.
#Type 'source ./mcd nested/dir' or '. ./mcd nested/dir'.
#source is a command that executes the script in the current shell(synonym of (.)).
