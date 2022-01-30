#Consider the following file:

# #slekariev@Z10029 ~ % cat ./mcd.sh
# #!/bin/zsh

# mkdir -p $1
# cd $1

# And let's say I run

# ./mcd nested/dir

# The nested directory is created, but the working directory didn't change. Why?


# Ответ:в данной ситуации мы запускаем скрипт, а каждый скрипт выполняется в своем собственном subshell , и является отдельным процессом, который не может менять свою рабочую директорию с помощью
# скрипта, записанного в файл.

