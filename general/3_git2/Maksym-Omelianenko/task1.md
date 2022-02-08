# Task 1: Solving conflicts

Description: the task is to create conflicts. So, first of all we create random file 
(in my case it's list of names). After that we commit it using `git add <name>`
to include in what will be committed and `git commit -m <message>` to commit it. 

# Screenshot 1
# Screenshot 2

Then we create new local and remote branches using `git checkout -b <name>`.

# Screenshot 3

Now, let's add some names to the list on remote branch, commit it and push using:

```
git add .
git commit -m <message>
git push --set-upstream origin <branch>
```
# Screenshot 4
# Screenshot 5
# Screenshot 6

Then we add other names to the list on local branch, commit it and try to pull using
previous commands and `git pull origin <name>` to pull branch. But we have a conflict,
which should be resolved before we can merge remote branch into local.

# Screenshot 7
# Screenshot 8
# Screenshot 9

So, to resolve this conflict in Visual Studion Code, for example, and accept local changes 
we should just click on "Accept current change", commit it, push the change to the remote and
pull change into the remote branch using:

```
git add .
git commit -m <message>
git push
git pull origin <name>
```

# Screenshot 10
# Screenshot 11
# Screenshot 12
# Screenshot 13

After that when we check the pull request, the pull request will still be open and
we'll no longer see any merge conflicts.

# Screenshot 14

If we want to accept remote change instead of local we should do exactly the same,
but this time we'll click on "Accept incoming change" and we don't need to pull again.

# Screenshot 15
# Screenshot 16
# Screenshot 17

And if we want to accept both of the changes, we can do all the same,
but click on "Accept both changes".

# Screenshot 18
# Screenshot 19
# Screenshot 20

Conclusions: we can also resolve conflicts in other way, for example rewriting file,
but I think this method is the most convenient.
