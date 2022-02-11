I set to try "git squash". I think this is a useful feature. It helps to make the commit history clearer and cleaner.

1. I created a new branch.
2. Created a file in it.
3. Made changes to the file and did "git add ." "git commit -m <comment>".
4. Repeat step 3 four times.
[screenshot-task3-1] (./Task3-img/Task3_1.png)
5. On the last commit, I noticed that I made a mistake in the commit message. I decided to fix it with "git commit --amend".
[screenshot-task3-1] (./Task3-img/Task3_2.png)
6. As a result, we have many commits. It wouldn't be bad to put them together.
[screenshot-task3-1] (./Task3-img/Task3_3.png)
[screenshot-task3-1] (./Task3-img/Task3_4.png)
7. I do "git rebase -i HEAD~<number of commits we want to merge>".
[screenshot-task3-1] (./Task3-img/Task3_5.png)
[screenshot-task3-1] (./Task3-img/Task3_6.png)
[screenshot-task3-1] (./Task3-img/Task3_7.png)
8. As a result, we have only one commit in history.
[screenshot-task3-1] (./Task3-img/Task3_8.png)
[screenshot-task3-1] (./Task3-img/Task3_9.png)

[Link] (https://github.com/TatianaMorozova04/2HW-git-Morozova-Tania)