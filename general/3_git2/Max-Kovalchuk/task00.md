# Task 0: Setting up remote repo

## Create my repo:

![Create on GitHub](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task00-1.png)

Next, I clone the repo to myself remotely and set up a connection between the local and remote repo, create a **.gitignore** file:

`git clone git@github.com:Maks90Kovalchuk/zoola-academy-homework3-git2.git`

`nano .gitignore`

`git add .gitignore`

`git commit -m 'Add file .gitignore'`

`git push -u origin main`:

![Create and push .gitignore](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/gitignore-task00.png)

Then I create a new branch and create a file name-surname in it:

`git checkout -b 'task00'`

`touch Max-Kovalchuk.txt`

`git add Max-Kovalchuk.txt`

`git commit -m 'Add .txt file for task00'`

`git push -u origin task00`

`git log:`

![Log](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/log-task00.png)

### Conclusions

I don't even know what to say in the conclusions to this task :) Basic knowledge and commands of the git that everyone should know.

- [Link](https://github.com/Maks90Kovalchuk/zoola-academy-homework3-git2) on my homework repo