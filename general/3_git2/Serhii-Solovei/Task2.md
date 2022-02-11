	##Task 2: Merge vs Rebase
	Use merge
At first I create file test_1 on 'main' branch and write some text. 
Then I add it  and commit. Repeat for a few times.
$ nano test_1.txt => $ git add . => $ git commit -m "Create file test_1"
$ nano test_1.txt => $ git add . => $ git commit -m "Update file test_1 and add second line"
$ nano test_1.txt => $ git add . => $ git commit -m "Update file test_1 and add third line"

$ git log
commit 2d750e288b97499e11f08564a40459edca0cea6b (HEAD -> main)
Author: Your Name <you@example.com>
Date:   Fri Feb 11 23:55:25 2022 +0200

    Update file test_1 and add third line

commit 1426986bc5bfed122c7b9e74bf4046446f6651b8
Author: Your Name <you@example.com>
Date:   Fri Feb 11 23:52:21 2022 +0200

    Update file test_1 and add second line

commit 4ac2ef38299e0b40e6f46e8fd3c9cffe528b28e7
Author: Your Name <you@example.com>
Date:   Fri Feb 11 23:50:56 2022 +0200

    Create file test_1

Then create a new branch 'task-2-GIT' and do the same things: create file, make few commits.
$git checkout -b task-2-GIT
$ nano test_2.txt => $ git add . => $ git commit -m "Create file test_2"
$ nano test_2.txt => $ git add . => $ git commit -m "Update file test_2 and add second row"

$ git log
commit 9f61968cbbc23a2cdc67d478e8c8a17f516b0008 (HEAD -> task-2-GIT)
Author: Your Name <you@example.com>
Date:   Sat Feb 12 00:03:26 2022 +0200

    Update file test_2 and add second row

commit 6f88ae74bcf6cd5b3a3a125e36d0137e9e22e426
Author: Your Name <you@example.com>
Date:   Sat Feb 12 00:01:04 2022 +0200

    Create file test_2


Then I switch back to 'main' and add one change in test_1 file.
$git checkout main
$ nano test_1.txt => $ git add . => $ git commit -m "Update file test_1 and add fourh line"

Then switch again to branch 'task-2-GIT'
$git merge main (add screenshot)

Merge succesful.
S@V580 MINGW64 ~/Desktop/zoola-academy/homework/HW 3 GIT/test-repo-HW-GIT (task-2-GIT)
$ ls -l
total 4
-rw-r--r-- 1 S 197121 141 фев 11 23:49 List_of_favorite_board_games
-rw-r--r-- 1 S 197121  22 фев 11 23:49 README.md
-rw-r--r-- 1 S 197121  50 фев 12 00:05 test_1.txt
-rw-r--r-- 1 S 197121  23 фев 12 00:05 test_2.txt

	Use rebase
In already created files in both branches I add some changes.
$git checkout task-2-GIT
$ nano test_2.txt => $ git add . => $ git commit -m "Update file test_2 and add third row"
$ nano test_2.txt => $ git add . => $ git commit -m "Update file test_2 and add fourth row"

Then I switch back to 'main' and add some changes in test_1 file.
$git checkout main
$ nano test_1.txt => $ git add . => $ git commit -m "Update file test_1 and add fifth line"
$ nano test_1.txt => $ git add . => $ git commit -m "Update file test_1 and add sixth line"

Then switch to branch 'task-2-GIT'
$git checkout task-2-GIT
$git rebase main (add screenshot)


Which command did you like the most?
For me it's better to use 'merge' because you can see all commits one after another by time and after merge 
will create additional commit with that message that we merge one branch to another. 

In which cases it is better to use git merge and when git rebase?
If you need to check correct time for each commits and which commit follow another it's better to use 'merge'.
If you need to have a clean and beautiful history of commits it's better to use 'rebase'.