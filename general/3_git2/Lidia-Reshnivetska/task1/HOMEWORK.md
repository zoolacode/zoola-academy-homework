### Task 1

Use the same remote github repo from previous task. The task is to create conflicts. 3 times.

1. First time – accept local changes instead of remote.

Merging main branch on my local branch:
![Screenshot](img/1.png)

After conflict I left only my changes:
![Screenshot](img/2.png)

Logs:
![Screenshot](img/3.png)

**Conclusion**: I have left only my changes (branch: 001-reshnivetska-hw) instead of changes which are on main branch

2. Second time – accept remote changes instead of local.

Conflict between main and local branches:
![Screenshot](img/4.png)

I left only remote changes (from main branch):
![Screenshot](img/5.png)

Logs:
![Screenshot](img/6.png)

**Conclusion**: I accepted only changes from main branch on branch: 001-reshnivetska-hw

3. Third time – accept both.

Changes for both branches:
![Screenshot](img/7.png)

Logs:
![Screenshot](img/8.png)

**Conclusion**: I accepted both conflicts, I edited marks like:
HEAD ======= etc

Thats why we see my name and co-worker`s name in file.
