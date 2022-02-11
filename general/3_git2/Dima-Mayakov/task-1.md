#Task 1: Solving conflicts
For this task ill working with two branches : "main" and "Dima-Mayakov-HW"

1.	Start from branch 'main'
2.	Add some changes in file "text-file" and commit them
	~git add .
	~git commit -m "Add changes in text-file from 'main' branch"
3.	Change to branch 'Dima-Mayakov-HW'
4.	Add some changes in file "text-file" and commit them
        ~git add .
	~git commit -m "Add changes in text-file from 'Dima-Mayakov-HW' branch"
5.	Try to merge 'main' branch with 'Dima-Mayakov-HW' branch
	~git checkout main 
	~git merge Dima-Mayakov-HW 
6.	After that we see next messege(task-1-CONFLICT-message.png):
	Auto-merging text-file
	CONFLICT (content): Merge conflict in text-file
	Automatic merge failed; fix conflicts and then commit the result.

After this step we must solve the conflicts
We can do this to accept:
	- changes in 'main' branch 
	- changes in 'Dima-Mayakov-HW' branch
	- all changes from two branches geather

7.	If we open the conflict file we will see the following :
	Dima Mayakov
	<<<<<<< HEAD
	Ivan Ivanov
	=======
	Petr Petrov

	>>>>>>> Dima-Mayakov-HW

	"<<<<<<HEAD" show the difference in current branch (Ivan Ivanov)
	"=========" show the difference in 'Dima-Mayakov-HW' branch (Petr Petrov)
 
#1.First time – accept local changes instead of remote.
8.	To do this we must delete all changes of 'main' branch
	and save only :
	
	Dima Mayakov
	Petr Petrov
	
	After that we can commit changes

#2.Second time – accept remote changes instead of local.
9.	To do this we must delete all changes of 'Dima-Mayakov-HW' branch
	and save only
	
	Dima Mayakov
        Ivan Ivanov
        
        After that we can commit changes
#3.Third time – accept both.
10.	To do this we accept all changes and save only

	Dima Mayakov
        Ivan Ivanov
        Petr Petrov

	After that we can commit changes
