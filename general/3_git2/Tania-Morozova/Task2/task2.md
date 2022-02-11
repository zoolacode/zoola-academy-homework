1. I create a new file and a new branch.
2. In the new branch, I also create a new text file and make a few changes in it. I'm doing a few commits.
3. I go to the "main" branch and make a few commits.
4. I return to the task branch and execute the command "git merge <name branch>" (in my case, I do "git merge main").
[screenshot-task2-1] (./Task2-img/Task2_1.png)
5. As a result, we get a new commit and on the chart in idea you can see how the merge happened.
[screenshot-task2-2] (./Task2-img/Task2_2.png)
6. I do again step 2, 3.
7. I return to the branch and execute the command "git rebase <name branch>" (in my case, I do "git rebase main").
[screenshot-task2-3] (./Task2-img/Task2_3.png)
8. As a result, we don't have a visible commit on the chart in idea.
[screenshot-task2-4] (./Task2-img/Task2_4.png)
[screenshot-task2-5] (./Task2-img/Task2_5.png)
[screenshot-task2-6] (./Task2-img/Task2_6.png)

For me, it is more preferable now to use "git merge". I can clearly see what I did at each step in the commit history.

It seems to me that when working locally it is more convenient to use "git rebase". If it does not affect either how the work of others. I'm more comfortable using "git merge" now.

[Link] (https://github.com/TatianaMorozova04/2HW-git-Morozova-Tania)