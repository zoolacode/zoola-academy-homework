# Task 2: Merge vs Rebase
### Create new branch
![new-branch]./images/Снимок экрана от 2022-02-09 03-50-56.png
### Back to the main, create a new file and something write in it
### Go to the task_2 branch and merge main
![merge-branch]./images/Снимок экрана от 2022-02-09 04-00-24.png
![merge-branch]./images/Снимок экрана от 2022-02-09 04-00-31.png
### Let`s do rebase
![rebase-branch]./images/Снимок экрана от 2022-02-09 04-10-52.png
### Discussion
Git Merge and Git Rebase serve the same purpose. 
They are designed to integrate changes from one branch into another. 
Although the end goal is the same, the operating principles are different.
As a team grows, it becomes difficult to manage or keep track of development changes using a merge. To have a clean and understandable commit history, it is wise to use Rebase.
### Benefits Git Merge
1. Simplicity;
2. Preserves the complete history and chronological order;
3. Maintains the branch context.
### Benefits Git Rebase
1. Simplifies a potentially complex story
2. Simplify manipulation with a single commit
3. Avoid merging commits in busy repositories and branches
4. Cleans up intermediate commits, making them one commit, which is useful for DevOps teams
