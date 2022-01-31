#Consider the following file:

# #slekariev@Z10029 ~ % cat ./mcd.sh
# #!/bin/zsh

# mkdir -p $1
# cd $1

# And let's say I run

# ./mcd nested/dir

# The nested directory is created, but the working directory didn't change. Why?


# Answer: we run a script, and each script runs in its own subshell, and is a separate process that cannot change its working directory with script written to file.
