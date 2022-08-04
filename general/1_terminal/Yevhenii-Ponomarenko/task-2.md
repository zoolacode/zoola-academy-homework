## Question
Why doesn't the `cd` command work in `.sh` scripts?

### Answer
Because shell scripts are executed in a subprocess (child process). When script execution ends, child process is killed and control is returned back to the parent process (the one that called the script). Therefore, cd command *does* work, but only inside of the script. When its execution finishes, we are brought back where we were when we launched the file.

To prevent the script from launching in a separate subprocess and instead force it to utilize current shell, use `. ./script.sh` or `source ./script.sh` where `./script.sh` is the script you are trying to use.

So you would have to change the command you are using to `. ./mcd nested/dir`.
