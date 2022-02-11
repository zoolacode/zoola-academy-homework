Hello:) Of course as a typycal "student" I start to do my homework in the last day. Sorry, if I make mistakes.
I think one of the most important think is a good mood, so try to keep it until the end of my answers, even if it's not easy :) 

First of all what I understand, that I didn't delete my old branch from previous homework. 
I tried $git pull from that branch and got answer "Already up to date".

S@V580 MINGW64 ~/Desktop/zoola-academy/zoola-academy-homework (Serhii-Solovei-Terminal-1)
$ git pull
Already up to date.

$ git status
On branch Serhii-Solovei-Terminal-1
Your branch is up to date with 'origin/Serhii-Solovei-Terminal-1'.

nothing to commit, working tree clean

Then, I tried to change branch to 'main' and saw this result of command. If be honest, didn't understand what is the problem.
S@V580 MINGW64 ~/Desktop/zoola-academy/zoola-academy-homework (Serhii-Solovei-Terminal-1)
$ git checkout main
error: pathspec 'main' did not match any file(s) known to git

I figure it out when change branch from temporary branch to 'master'
S@V580 MINGW64 ~/Desktop/zoola-academy/zoola-academy-homework (Serhii-Solovei-Terminal-1)
$ git checkout master
Switched to branch 'master'
Your branch is up to date with 'origin/master'.

Finally, I changed!) but, you know, again 'Already up to date'. "HOW ITS EVEN POSSIBLE?" - I thought...
S@V580 MINGW64 ~/Desktop/zoola-academy/zoola-academy-homework (master)
$ git pull
Already up to date.

Then I understand that I'm not so clever person:) First of all I need to 'fetch and merge' changes in GitHub from zoola repo to mine clone version of this repo.
$ git pull
remote: Enumerating objects: 1075, done.
remote: Counting objects: 100% (1068/1068), done.
remote: Compressing objects: 100% (664/664), done.
remote: Total 1057 (delta 333), reused 859 (delta 218), pack-reused 0
Receiving objects: 100% (1057/1057), 2.02 MiB | 544.00 KiB/s, done.
Resolving deltas: 100% (333/333), completed with 3 local objects.
From https://github.com/SerhiiSolovei/zoola-academy-homework
   76bb130..f2555d6  master     -> origin/master
Updating 76bb130..f2555d6
Fast-forward
... and a lot of more lines.

I need to create a new branch for GIT homework and create a new directory in which I'll push files with my homeworks. 
S@V580 MINGW64 ~/Desktop/zoola-academy/zoola-academy-homework (master)
$ git checkout -b Serhii-Solovei-GIT-3
Switched to a new branch 'Serhii-Solovei-GIT-3'

Then I used command 'cd' to move in the correct directory where I need to create my own new one. 
For create that new directory I used 'mkdir' command. 
S@V580 MINGW64 ~/Desktop/zoola-academy/zoola-academy-homework/general/3_git2 (Serhii-Solovei-GIT-3)
$ ls -l
total 4
-rw-r--r-- 1 S 197121 2092 фев 11 11:13 README.md
drwxr-xr-x 1 S 197121    0 фев 11 11:30 Serhii-Solovei/

Finally some period of time with preparation I can start to do my homework.

	##Create new public repo in github.
I add screenshots how I create public repo.

	##Set it up both remote and local.
Using command 'cd' I find necessary directory where I can create a new directory for that homework. 
I need to initialize remote repo on my device in that directory.
S@V580 MINGW64 ~/Desktop/zoola-academy/homework/HW 3 GIT
$ mkdir test-repo-HW-GIT

S@V580 MINGW64 ~/Desktop/zoola-academy/homework/HW 3 GIT
$ cd test-repo-HW-GIT/

Inside of this repo it's necessary to initialize remote repo using command 'git init'.
S@V580 MINGW64 ~/Desktop/zoola-academy/homework/HW 3 GIT/test-repo-HW-GIT
$ git init
Initialized empty Git repository in C:/Users/S/Desktop/zoola-academy/homework/HW 3 GIT/test-repo-HW-GIT/.git/

	##Create new branch.
S@V580 MINGW64 ~/Desktop/zoola-academy/homework/HW 3 GIT/test-repo-HW-GIT (master)
$ git checkout -b Serhii-Solovei-HW-GIT
Switched to a new branch 'Serhii-Solovei-HW-GIT'
	
	##Create text file with your name and surname.
For creating simple txt file with some text I use 'nano' command. 
First, I create file with standart text 'Hello World!!!' then I double check with home task nad using command 'nano.txt' one more time. 
I change text to my name and surname.

	##Commit it.
First you need to add files which should be committed. Check status.
$ git add .
$ git status
On branch Serhii-Solovei-HW-GIT

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   test.txt

$ git commit -m "Create text file with your name and surname"
[Serhii-Solovei-HW-GIT (root-commit) fc20450] Create text file with your name and surname
 1 file changed, 1 insertion(+)
 create mode 100644 test.txt

	##Push your branch.
You need to set path to the remote repo and then push your changes.
S@V580 MINGW64 ~/Desktop/zoola-academy/homework/HW 3 GIT/test-repo-HW-GIT (Serhii-Solovei-HW-GIT)
$ git remote add origin https://github.com/SerhiiSolovei/test-repo-for-GIT-HW.git


S@V580 MINGW64 ~/Desktop/zoola-academy/homework/HW 3 GIT/test-repo-HW-GIT (Serhii-Solovei-HW-GIT)
$ git push -u origin Serhii-Solovei-HW-GIT

After this I make another commit and add all screenshots to that repo using the same commands.

	##Make sure your .gitignore file exists :) and you did not push any unnecessary files.
For that moment I don't have any unnecessary files, so I didn't create .gitignore file.
$ git status
On branch Serhii-Solovei-HW-GIT
Your branch is up to date with 'origin/Serhii-Solovei-HW-GIT'.

nothing to commit, working tree clean

	##Show the git logs.
commit f589ad30a2ec9c848c8437a7cfe6773af64ffbeb (HEAD -> Serhii-Solovei-HW-GIT, origin/Serhii-Solovei-HW-GIT)
Author: Your Name <you@example.com>
Date:   Fri Feb 11 12:23:11 2022 +0200

    Add screenshots for first GIT homework task

commit fc20450ce20ff4e7b7a1b125d09723691f0ebf9e
Author: Your Name <you@example.com>
Date:   Fri Feb 11 12:10:44 2022 +0200

    Create text file with your name and surname

	
	##Do not forget to attach a link to your repo in results.
https://github.com/SerhiiSolovei/test-repo-for-GIT-HW
I keep all screenshots there.