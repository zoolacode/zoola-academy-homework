#!/bin/zsh
mkdir -p $1
cd $1

#ANSWEAR:CD command works, but only inside the skrips, because we launching it in a subprocess.
#Which means, when execution ends, subprocess will be destroyed, we will be on current process.    
#To fix the issue, you have to launch it on current process
#Type 'source ./mcd nested/dir' or '. ./mcd nested/dir'
#source is command that executes script in the current shell(synonym of (.)).

