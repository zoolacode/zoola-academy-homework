Task01
------------------------------------
Accept changes from “main” in github
------------------------------------

❯ git log // I did a lot of commits. But I didn’t have screenshots, so let’s start again.
❯ git status // I have some file, which suddenly appeared and just as suddenly disappeared.

On branch main
Your branch is up to date with 'origin/main'.
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
	deleted:    .my-name.txr.swp

❯ git commit -m "delete random file" 
❯ git push -u
❯ git status
All ok
❯ nano new-file.txt //create a new file. With name “new-file.txt”

New file for task 02.
I tried creating conflicts in previous commits, but I didn't take screenshots. So
This line I want to keep

❯ git status
Untracked files:
  (use "git add <file>..." to include in what will be committed)
	new-file.txt

❯ git add .
❯ git commit -m "Create new-file.txt and add new lines for task01"
❯ git push

Create new branch:
❯ git checkout -b branch-for-task01
Switched to a new branch 'branch-for-task01'
❯ ls
my-name.txt  new-file.txt  README.md
❯ nano new-file.txt
Now my text was:

New file for task 01. //I changed number
I tried creating conflicts in previous commits, but I didn't take screenshots. So
This line I want to keep
This line from new branch branch-for-task01 //add new line

❯ git add .
❯ git commit -m "Change file new-file.txt: in line 1 chanche 'task02' on 'task01' and add new line with branch's name"
❯ git push -u origin branch-for-task01

Changed branch on main:
❯ git checkout main
Switched to branch 'main'
❯ nano new-file.txt

New file for task 01. //I changed number
I tried creating conflicts in previous commits, but I didn't take screenshots. So
This line I want to keep
This line I want to delete // I create a conflict

❯ git add .
❯ git commit -m "Change file new-file.txt: add new line 4 with text what need to delete"
❯ git push (pics 1.1, 1.2, 1.3 - all git commands)
 ···············································································································································
In github request I pick "Pull requests” → compare & pull request . And I have an error.
 “Can’t automatically merge. Don’t worry, you can still create the pull request.”
I added name “Change file new-file.txt” and description “ in line 1 change 'task02' on 'task01' and added a new line with the branch's name”
And chose create pull request..

After I got “This branch has conflicts that must be resolved
Use the web editor or the  to resolve conflicts. Conflicting files: new-file.txt” error. And chose “Resolve conflict”.
I had this conflict text:
<<<<<<< branch-for-task01
This line from new branch branch-for-task01
=======
This line I want to delete
>>>>>>> main
I decided to keep branch-for-task01 solution.
And mark as resolved → commit merge.
After merge pull request and confirm merge.

------------------------------
Accept my changes in terminal:
------------------------------
In terminal:
Branch main: 
❯ git pull
❯ git checkout -b branch-for-accept-my-changes //create new branch
Switched to a new branch 'branch-for-accept-my-changes'
❯ nano new-file.txt //deleted 3-4 lines and changed 2 line
                                                                      
New file for task01.
And I want to change this file for conflict.

❯ git commit -am "Change new-file.txt: delete 3 and 4 lines and add new text for conflict"
❯ git push -u origin branch-for-accept-my-changes

❯ git checkout main
Switched to branch 'main'
❯ nano new-file.txt // add line 5
                                                          
New file for task 01.
I tried creating conflicts in previous commits, but I didn't take screenshots. So
This line I want to keep
This line from new branch branch-for-task01
And here you find the text that never gonna used

❯ git add .
❯ git commit -m "Change new-file.txt: add some text on line 5"
❯ git push

Checked my pull request in github →  “compare & pull request “.  I had an error.
 “Can’t automatically merge. Don’t worry, you can still create the pull request.”
After I came back to terminal.
❯ git checkout branch-for-accept-my-changes
❯ git merge main 
Auto-merging new-file.txt
CONFLICT (content): Merge conflict in new-file.txt
Automatic merge failed; fix conflicts and then commit the result.
So, I needed to fix it. 
❯ nano new-file.txt (pics 1.4, 1.5, 1.6)
<<<<<<< HEAD
New file for task01.
And I want to change this file for conflict.
=======
New file for task 01.
I tried creating conflicts in previous commits, but I didn't take screenshots. So
This line I want to keep
This line from new branch branch-for-task01
And here you find the text that never gonna used
>>>>>>> main

❯ git commit // it didn’t work, because I didn’t add this file
U	new-file.txt
error: Committing is not possible because you have unmerged files.
hint: Fix them up in the work tree, and then use 'git add/rm <file>'
hint: as appropriate to mark resolution and make a commit.
fatal: Exiting because of an unresolved conflict.
❯ git add .
❯ git commit -m "Merge new-file.txt in terminal, accept my changes"
[branch-for-accept-my-changes 0828e67] Merge new-file.txt in terminal, accept my changes
❯ git push (pic. 1.7)
❯ git log (pic. 1.8)
After all this command the problem was solve. Pull request was accept. → create pull request. 
This branch has no conflicts with the base branch → Merge pull request → confirm merge.

❯ git checkout main
Switched to branch 'main'

-------------------------------
Accept all changes from “main”
-------------------------------
On branch main change new-file.txt

"title": "The Great Gatsby"
"imdb_score": 7.2

"name": "Harry Potter and the Prisoner of Azkaban"
"imdb_score": 7.9

❯ git commit -am "Add 2 my favorite movies to new-file.txt"
[main bdaa872] Add 2 my favorite movies to new-file.txt
 1 file changed, 7 insertions(+), 1 deletion(-)
❯ git push
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 403 bytes | 403.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0)
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To github.com:danta-m/za-homework-repo.git
   f5eb055..bdaa872  main -> main
❯ git pull
Already up to date.

Create 2 branches:
first-person-fix-score
second-person-fix-score
(pic. 1.9, 1.10)
On branch “second-person-fix-score” I change score first movie:
❯ nano new-file.txt
 
"title": "The Great Gatsby"
"imdb_score": 7.0

"name": "Harry Potter and the Prisoner of Azkaban"
"imdb_score": 7.9

❯ git add .
❯ git commit "Change score 'The Great Gatsby' on 7.0"
❯ git push -u origin second-person-fix-score


On branch “first-person-fix-score” I change score first movie:
❯ nano new-file.txt
 
"title": "The Great Gatsby"
"imdb_score": 8.0

"name": "Harry Potter and the Prisoner of Azkaban"
"imdb_score": 7.9

❯ git add .
❯ git commit "Change score 'The Great Gatsby' on 8.0"
❯ git push -u origin first-person-fix-score

After I went to github and saw 2 my pull requests from 2 branches.
 I merged “first-person-fix-score”.
And I had a conflict on 2nd branch. 
❯ git checkout main
Switched to branch 'main'
❯ git pull
 new-file.txt | 2 +-
 
❯ git checkout second-person-fix-score
Switched to branch 'second-person-fix-score'

❯ git merge main
Auto-merging new-file.txt
CONFLICT (content): Merge conflict in new-file.txt
Automatic merge failed; fix conflicts and then commit the result.
❯ nano new-file.txt
I kept solutions from 2 branches.
❯ git add .
❯ git commit
[second-person-fix-score 7200609] Merge branch 'main' into second-person-fix-score
❯ git push
And now I able to merge.

