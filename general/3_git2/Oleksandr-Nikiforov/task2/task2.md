1.Git merge

Add new line to olnikiforov.txt on "conflict-branch" 
git add + commit cheanges
checkout on main branch
Then git merge conflict-branch
 
2.Git rebase

Add new line to olnikiforov.txt on "conflict-branch" 
git add + commit cheanges
checkout on main branch
Then git merge conflict-branch 

Question 1.

I prefer more to use "git merge", because this operation avoids potential problems associated with running the rebase command.

Question 2.

Benefits of git rebase:
-Streamlines a potentialy complex history
-Avoids merge commit spam in busy repos
-Cleans intermediate commits by making them a single commit, which can be helpful for DevOps teams

Benefits of git merge:
-Simple and familiar
-Preserves complete history and chronological order
-Maintains the context of the branch  
