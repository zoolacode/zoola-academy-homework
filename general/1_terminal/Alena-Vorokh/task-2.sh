#Task 2
#!/bin/bash

#The "current" or "working" directory is a per-process parameter,
#and a process can only change its own working directory.
#Standalone scripts are executed as a separate shell process and cannot affect the parent shell

#I think that you need to use function(), and your code will look like this:

function mkcd(){
  mkdir $1
  cd $1
}

#or

mkcd(){ mkdir "$1" && cd "$1" ; }

#But as soon as the script exits we will be back where we started. 
#This is because of the fact that the script is not being executed in a subshell that is on a different process.
#To make it system wide we'll use an alias.

alias mkcd='. ~/mkcdn.sh'
