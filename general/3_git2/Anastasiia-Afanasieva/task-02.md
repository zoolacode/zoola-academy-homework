# Task 2: Merge vs Rebase

1. I change the branch to `main` using `git checkout main`.
2. Create file `MergevsRebase.txt`.
3. `git add`, `git commit`.
4. I will use commit messages like these: `1-Main`, `2-Merge`, `4-Rebase` to better understand how merge and rebase work, to visualize the difference between them. I understand that they're not the best commit messages, but it helps me to see the difference.
5. Create two branches: `git branch merge-branch` and `git branch rebase-branch`.
6. In `merge-branch` create file `merge.txt`.
7. In `rebase-branch` create file `rebase.txt`.
8. Make some changes in files and commits in `main`, `merge`, `rebase` branches.
9. It was important for me to number them and name them depending on the branch where they were made, because, in the end, after merge and rebase, using `git log` we'll see the difference between `merge` and `rebase`.
10. `git checkout merge-branch` and `git merge main`.
11. `git checkout rebase-branch` and `git rebase main`.

## The result of `merge`:
![merge_example](https://raw.githubusercontent.com/anastasiiaafanasieva/images/main/merge_example.png?token=GHSAT0AAAAAABQNRDJYWUSJJBVBZHXTOMGUYQC2SRA)

## The result of `rebase`:
![rebase_example](https://raw.githubusercontent.com/anastasiiaafanasieva/images/main/rebase_example.png?token=GHSAT0AAAAAABQNRDJYMUZO7Z7PPUH3ZW36YQC2S5Q)

## Which command did you like the most?
As of now, I prefer `merge` to track and see my history, but it was useful to try and see how `rebase` works!


## In which cases it is better to use git merge and when git rebase?
If the team uses a feature-based workflow, using git merge may be the best option for preserving the commit history for any given feature. You don't need to worry about overriding commits or "changing history". 
With git merge, different features remain isolated and don't interfere with existing commit histories.

If keeping commit history clean is a priority, then rebasing may be most appropriate. It will avoid unnecessary commits and keep changes more centralized and linear.
