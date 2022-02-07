# merge two files into one with line history preserved



In this task, i decided to merge two files that have their own commit history into one. Let's say we have a file with **cars** and **smartphones**, and they are constantly updated by different users:

- **cars:**

  ![Create cars](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-1.png)

  - **smartphone:**

    ![Create smartphone](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-2.png)

    Next =>`git tag ready`

Now we have two files with different commit histories, and `git blame` shows, who wrote which line.

​    `git blame cars`

![blame cars](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-3.png)

​    `git blame smartphone`

![blame smartphone](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-4.png)

Now (for something :D) Sergey (for example) decided that we need to combine these two files into one with the name **cars-and-smartphones**. Being young and inexperienced, Sergey took the naive path and decided to merge the files into one commit:

​	`cat cars smartphone > cars-and-smartphones`

​	`git rm cars smartphone`

​    ` git add cars-and-smartphones`

​    `git commit --author='Sergey <sergey>' -m 'merge files'`

Let's take a look at `git blame cars-and-smartphones`:

![blame cars-and-smartphones](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-5.png)

The history of **smartphones** is preserved, but the history of **cars** is gone. The git in this commit saw that 1 file appeared renamed and two disappeared, because most of the **cars-and-smartphones** file corresponds to the **smartphone** file, it concludes that you deleted the **cars** file, renamed the **smartphone** file to **cars-and-smartphones**, and then added three new lines at the top of **cars-and-smartphones**.

We can tweak the `git blame` algorithms with options like `-M`(Detect moved or copied lines within a file) and `-C`(In addition to -M, detect lines moved or copied from other files that were modified in the same commit) to make it try harder, but in practice you don't often have control over these options: `git blame` can be run on the server and the results are reported back to us on a [web page](). Or `git blame` is run by a developer sitting remotely (whose command-line options you have no control over), and Sergey has to deal with all the tickets assigned to him by people who used `git blame` output to find out who entered the line causing problems.

I need to get the correct history for both the **cars** and the **smartphone**. Let’s reset back to the original state: 

​	`git reset --hard ready`

![git reset](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-6.png)

I set up two branches. In one branch, I rename **smartphone** to **cars-and-smartphones**:

![checkout -b](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-7.png)

In the other branch, we rename **cars** to **cars-and-smartphones**:

![checkout -](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-8.png)

`git merge -m 'merge cars and smartphones' rename-smartphone`

![git merge](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-9.png)

At this point, I create the resulting **cars-and-smartphones** file by merging the two originals:

![git cat with filter](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-10.png)

​	Next  =>`git add cars-and-smartphones` and =>`git merge --continue`

Git knows, to look in both merge parents to find out what happened. And this is where he sees that each parent provided half of the file, and also sees that the files in each branch were themselves created by renaming other files, so he can trace the history in both source files:

![git blame](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-11.png)

`git log`:

![git log](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task03-12.png)

The lines are spelled correctly and the history can now be traced back to each parent merge file. I hope it is written clearly, and questions will not arise, because I am finishing this text in 6 A.M. I hope all reviewers like it :)

