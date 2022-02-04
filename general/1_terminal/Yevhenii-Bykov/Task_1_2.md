# Task 1,2
### Task_1

To output the name of files that have `zoola` in their names i used:

```sh
find ./ -name "*zoola*"
```
And i get files from the current folder that have `zoola` in their name.

## Task2
> The nested directory is created, but the working directory didn't change. Why? 

After the script executes we come back to the very folder where the script was executed, that’s why we don’t go to a new folder.