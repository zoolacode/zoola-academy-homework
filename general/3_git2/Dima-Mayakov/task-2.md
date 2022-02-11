#Task 2: Merge vs Rebase
Integrate changes from one branch into another branch using:
#1.git merge.
To show how to use comand 'git merge' ill use my prev local repo
we will start from next log (start-log.png): 
	For example create new file from 'main' branch 'new-text-file-main' 
	and commit it 
	~git add .
	~git commit -m "add new file 'new-text-file-main"
Then swich to branch 'Dima-Mayakov-HW'
if we look on log from that poit we will see that directory didt changed (sart-log-from-DMHW.png)
We can add new file in the same directory from this branch and commit this
And see diference in log (log-from-DMHW.png)

Then to see changes from 'main' branch we need comand:
	~git merge main
After that we will see next log (merge-log.png) what show to as all changes from too branches at one directory
#2.git rebase.
Because I don't often use rebase i try to use simple branch and examples files
I create new directory based on prev task and take "start log" (start-point-log-rebase.png)
 for example i create 2 file in each branches and commit it
for main branch (main-log-add-file-rebase.png)
for Dima branch (Dima-log-add-file-rebase.png)
Then from main branch i try use rebase:
	~git rebase -i Dima 
In log (rebase-log.png) we see all changes geather without inform about "marge" comand

I liked more merge because it creates a new commits to better control changes
 but rebase better when all my changes on master branch not related on changes head branch .

