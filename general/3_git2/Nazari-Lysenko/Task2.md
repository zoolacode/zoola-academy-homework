### Task 2

1. Description: made changes in main branch and than merged them into another branch with `git merge`. Then did the same thing with `git rebase`
2. Used git commands:
    1. git push
    2. git merge
    3. git log
    4. git commit
    5. git add
    6. git rebase
3. Screenshots:
   1. Since my branch is 1 commit behind main I can `git merge` main into task0 ![1 commit behind](task2-commit-behind.jpg)
   2. ![Merging](task2-merge.jpg)
   3. ![Log after merge](task2-merge-log.jpg)
   4. Graph after 3 conflicts from task1 (see Task1.md) and after `git merge` ![Graph](task2-merge-graph.jpg)
   5. Graph before rebase ![Graph](task2-graph-before-rebase.jpg)
   6. `git rebase` ![Rebase](task2-rebase-in-terminal.jpg)
   7. Result of rebase ![Result](task2-rebase-result.jpg)
4. Conclusion: `git merge` is much easier and more convenient than `git rebase`, so I liked merging more. It is better to use `git merge` when you had some conflicts on your branch in past and if you are not so interested it having beautiful history. `git rebase` can be used when you need to have perfect history of commits.