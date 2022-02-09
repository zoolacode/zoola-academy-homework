# Task 2: Merge vs Rebase

Description: we need to integrate changes from one branch into another branch using
`git merge` and `git rebase`.

## Merge

Let's create new branch using `git checkout -b <name>` and on the first branch add three
commits using `git add .` and `git commit <message>`. Now we can see these commits in log.

# Screenshot 1
# Screenshot 2

Then we create another branch and add two commits using earlier mentioned commands.

# Screenshot 3
# Screenshot 4

Now we add one commit on the first branch and try to merge using `git merge <name>`
second branch into. Certainly we have conflict, that can be solve like in previous
task and then merge it. Now we can see how log looks after merging.

# Screenshot 5
# Screenshot 6

## Rebase

For this task we just repeat process describing earlier but instead of using `git merge`, 
we'll use `git rebase` and after resolving conflict use `git rebase --continue` to continue
rebasing. Now we can see how log looks after rebasing.

# Screenshot 7
# Screenshot 8
# Screenshot 9
# Screenshot 10
# Screenshot 11
# Screenshot 12

## Questions: 

1.Which command did you like the most?

My short answer is `git merge` the most convenient because after using it we and someone else
can see all the change in log.

2.In which cases it is better to use `git merge` and when `git rebase`?

If you want to keep clean and readable git history, it's better to use `git rebase`.
However, if for example date of commit is important for some reason, than you should
use `git merge`, because `git rebase` technically move commits and lose the initial commit time.

Conclusions: `git merge` and `git rebase` is basic git commands that do exactly tha same action,
but in a differnt way. Everyone choose what the most appropriate for them and when.
