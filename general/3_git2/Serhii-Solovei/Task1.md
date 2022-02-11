	##First time – accept local changes instead of remote.
First you have to move to 'main' branch using command $git checkout main
Create a file "List_of_favorite_board_games" => $nano "List_of_favorite_board_games.txt" 
and add first game "Ticket to ride".
Add it and commit => $git add . => $ git commit -m "Create a file with favorite board games and add first one"

Then I create another branch => $git checkout -b task-1-solving-conflicts.
Make some changes in file => $nano "List_of_favorite_board_games.txt" add second game "Catan".
Add it and commit => $git add . => $ git commit -m "Add second game to file with list of board games"

Then I change branch back to "main" and merge changes => $ git checkout main => $ git merge task-1-solving-conflicts.
Now I have updated file with list of games in that branch.
Make some changes in file $nano "List_of_favorite_board_games.txt" add third game "7 Wonders".
Add it and commit => $git add . => $ git commit -m "Add third game to file with list of board games" 

Change back to "task-1-solving-conflicts" branch => $git checkout task-1-solving-conflicts.
At first I make some changes in the file and add new game. I have only two games in my file, 
because I didn't merge changes which I made in 'main' branch.
$nano "List_of_favorite_board_games.txt" add third game "7 Wonders. Duel version".
Add it and commit => $git add . => $ git commit -m "Add third game to list of board games".
Now I try to merge changes from 'main' branch => $ git merge main and get that problem.
$ git merge main
Auto-merging List_of_favorite_board_games
CONFLICT (content): Merge conflict in List_of_favorite_board_games
Automatic merge failed; fix conflicts and then commit the result.

$ git status
On branch task-1-solving-conflicts
You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   List_of_favorite_board_games

no changes added to commit (use "git add" and/or "git commit -a")

As I want to keep changes from local 'task-1-solving-conflicts' branch I do the next things:
$ nano List_of_favorite_board_games
1. Ticket to ride
2. Catan
<<<<<<< HEAD - this is changes from current branch
3. 7 Wonders. Duel version - this is changes from current branch
=======
3. 7 Wonders - this is changes from main branch
>>>>>>> main - this is changes from main branch

Delete by hand changes from 'main' branch and keep from current one.
Add it and commit => $git add . => $ git commit -m "Resolved conflict in list of board games file"

Check status
$ git status
On branch task-1-solving-conflicts
nothing to commit, working tree clean

Then I move to 'main' branch and merge changes.
$ git checkout main => 
$ git merge task-1-solving-conflicts
Updating 61d7fc9..5d6c046
Fast-forward
 List_of_favorite_board_games | 2 +-
 1 file changed, 1 insertion(+), 1 deletion(-)

Check is everything correct.
$ cat List_of_favorite_board_games
1. Ticket to ride
2. Catan
3. 7 Wonders. Duel version

	## Second time – accept remote changes instead of local.
In the 'main' branch I change file with board games and add new one.
$nano "List_of_favorite_board_games.txt" add fourth game "Terraforming Mars".
Add it and commit => $git add . => $ git commit -m "Add fourth game to list of board games"
And push to repo => $git push origin main

Change branch to 'task-1-solving-conflicts'
In that branch I also try to add fourth game to he list.
$nano "List_of_favorite_board_games.txt" add fourth game "Dune".
Add it and commit => $git add . => $ git commit -m "Add fourth game "Dune" to list of board games"
Then I try to pull changes from our repo => $git pull origin main and got an error 
(Unfortunately, I can't paste code here what exactly it was the problem, because terminal hung when I was in 'revert' window. Sorry :( )

In that conflict I want to save changes from 'main' branch.
Cancel our merge - $git merge --abort.
Then revert last commit using $git log and check the id of necessary commit.
And $git pull origin main once again.

S@V580 MINGW64 ~/Desktop/zoola-academy/homework/HW 3 GIT/test-repo-HW-GIT (task-1-solving-conflicts)
$ git log
commit 831e254b9226a384ce48ae1988f4fbce08357050 (HEAD -> task-1-solving-conflicts)
Merge: e9b12f5 15766d6
Author: Your Name <you@example.com>
Date:   Fri Feb 11 22:14:31 2022 +0200

    Merge branch 'main' of https://github.com/SerhiiSolovei/test-repo-for-GIT-HW into task-1-solving-conflicts

commit e9b12f5485512bc1a02acf4600309c92dcce1273
Author: Your Name <you@example.com>
Date:   Fri Feb 11 21:58:11 2022 +0200

    Revert "Add fourh Dune game to the list"

    This reverts commit 04ba719b8dbfb11b4dcc8e3d5af06960d6610900.

commit 04ba719b8dbfb11b4dcc8e3d5af06960d6610900
Author: Your Name <you@example.com>
Date:   Fri Feb 11 21:56:44 2022 +0200

    Add fourh Dune game to the list
	

	##Third time – accept both.
In the 'main' branch I make some changes once again our list of games and push it to repo. 
I change first position from 'Ticket to ride' to 'Ticket to ride(Origin version in the USA).
$ git checkout main => $ nano List_of_favorite_board_games => $git add . =>
$ git commit -m "Change first position in our list of games" => $ git push origin main

Change branch to 'task-1-solving-conflicts' and do the same things just the changes name is 'Ticket to ride(Europe version)'.
$ git checkout task-1-solving-conflicts=> $ nano List_of_favorite_board_games => $git add . =>
$ git commit -m "Change first position in our list of games" => $ git push origin task-1-solving-conflicts

In GitHub repo when I switch branch to 'task-1-solving-conflicts' press button 'Compare & pull request'.
I can't merge pull request, because I had conflicts and I need to resolve at first. 
I want to keep both of variants, so after pressing button 'Resolve conflicts' in GitHub editor 
I change first position and keep both of them. (Yeah I remember, that our teacher Diana doesn't reccommend this way)

I add screenshots form GitHub in repo. https://github.com/SerhiiSolovei/test-repo-for-GIT-HW
   
