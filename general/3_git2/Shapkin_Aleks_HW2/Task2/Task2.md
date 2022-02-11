Task2 

Integrate changes from one branch into another branch using:

Git merge and git rebase do almost the same work but in a different way.

1. git merge.

Lets make some commits on main:
![Commits on main](./Task2-1.png)
Lets create a new branch merge-br

And make some changes in file:

![Commits on main](./Task2-2.png)

And add some commits:

![Commits on main](./Task2-3.png)

Now I can go to main and merge changes to main:

![Commits on main](./Task2-4.png)

![Commits on main](./Task2-5.png)

2. git rebase.

Rebase is using for change your history off commits in local.

Lets make same as in merge and try "git rebase main"

![Commits on main](./Task2-6.png)

And:

![Commits on main](./Task2-7.png)


Questions:

Which command did you like the most?

Git merge. its more useful for team work.

In which cases it is better to use git merge and when git rebase?

Git merge when need changes on remote.

Git rebase only on local to make your history more clean.