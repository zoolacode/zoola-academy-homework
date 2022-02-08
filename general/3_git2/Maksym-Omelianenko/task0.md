# Task 0: Setting up remote repo

Description: for creating new public repo in github we should just click on "New repository",
then choose appropriate parameters and click "Create repository".

## Screenshot 1

Then we clone this repository using `git clone <repository>` and set it up remote and local in this way.

## Screenshot 2

Next we create branch using `git checkout -b <name>`.
We can also use `git branch <name>` and `git checkout <name>` and do the same,
but we'll waste more time.

## Screenshot 3

After that we create text file with name and surname,
add it to update what will be committed using `git add <name>` or `git add .` to add all of the files.
Then we commit our changes typing `git commit -m <message>`.
Alternatively, we can use `git commit -am <message>` to do the same faster.

## Screenshot 4
## Screenshot 5

Finally, we can push our branch using `git push --set-upstream origin hw2-omelianenko-task0`
to push the current branch and set the remote as upstream.

## Screenshot 6
## Screenshot 7

Conclusions: creating, setting up and pushing repository is basic git action.
It isn't hard process, so I hope this instruction will be usefull for everyone.
Link to test repo: https://github.com/Omax0/test-repo-git-homework
