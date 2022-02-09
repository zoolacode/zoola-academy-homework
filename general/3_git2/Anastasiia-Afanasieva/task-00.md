# Task 0: Setting up remote repo

## Create new public repo in github.
  1. Go to github.com => your profile (in my case [My Profile](https://github.com/anastasiiaafanasieva)) => click on `Repositories` => click on green button `New` to create a new Repo.
  2. We see a new window, where we need to put a `Repository name` (in my case `test-repo-for-HW-3`) and choose `Public` in order others can have access to the Repo.
  3. Push the button `Create Repository`.

## Set it up both remote and local.
  1. Open Terminal and create a new directory `testRepository` using `mkdir` command.
  2. Move to the new folder using `cd ~/Documents/testRepository/`.
  3. Create a new README file `nano README.md`.
  4. In nano write description `Test repository for Homework #3 Git`.
  5. `git init` to initialize remote repo on my device.
  6. `git add README.md`.
  7. `git commit -m 'initial commit'`.
  8. `git branch -M main`. 
  9. `git remote add origin https://github.com/anastasiiaafanasieva/test-repo-for-HW-3-Git.git`. To set path to the remote repo.
  10. `git push -u origin main`. The git push -u command is equivalent to -set-upstream and automatically sets that repo as the upstream repo. In the future, Git knows where we want to push to and where we want to pull from, so we can use git pull or git push without arguments.

## Create new branch.
  1. `git checkout -b afanasieva-HW-3`. To create a new branch with the name `afanasieva-HW-3` and switch to it.
  2. Terminal shows us `Switched to a new branch 'afanasieva-HW-3'`. Successfully created and switched to a new branch.

## Create text file with your name and surname.
  1. `nano Anastasiia-Afanasieva.txt`.
  2. Enter `Anastasiia Afanasieva`. Save changes.

## Commit it.
  1. `git add Anastasiia-Afanasieva.txt`.
  2. `git status` to check the status of my file:
$$ On branch afanasieva-HW-3
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
	new file:   Anastasiia-Afanasieva.txt
$$
  3. `git commit -m 'Create txt file with name and surname'`.

## Push your branch.
  1. `git push origin afanasieva-HW-3`.
  2. Branch pushed.

## Make sure your .gitignore file exists :) and you did not push any unnecessary files.
  1. `git status` to check if we have some other files.
  2. We'll receive in Terminal window message:
$$ On branch afanasieva-HW-3
Untracked files:
  (use "git add <file>..." to include in what will be committed)
	.DS_Store
$$
  3. As I am using macOS, my system appends the .DS_Store file in my directory. I want to create and add it to .gitignore file by `nano .gitignore` and write there .DS_Store.
  4. `git add .gitignore`.
  5. `git commit -m 'Add .gitignore'`.
  6. `git push -u origin afanasieva-HW-3`. 

## Show the git logs.
  1. `git log`.
  2. Output we receive:

$$ anastasiiaafanasieva@Anastasiias-MacBook-Air testRepository % git log

commit bf1f295c8535673f4a35991c2ce24ce18871b050 (HEAD -> afanasieva-HW-3)
Author: Anastasiia Afanasieva <anastasiiaafanasieva@Anastasiias-MacBook-Air.local>
Date:   Tue Feb 8 13:27:55 2022 +0200

  Add .gitignore

commit bc0763b2cfb95df8211a2ff691edf51b696f1fe4 (origin/afanasieva-HW-3)
Author: Anastasiia Afanasieva <anastasiiaafanasieva@Anastasiias-MacBook-Air.local>
Date:   Tue Feb 8 13:26:22 2022 +0200

  Create txt file with name and surname

commit 150e693c63c4ff43eab20d5018db6bedcb7d2eaf (origin/main, main)
Author: Anastasiia Afanasieva <anastasiiaafanasieva@Anastasiias-MacBook-Air.local>
Date:   Tue Feb 8 13:24:09 2022 +0200

  Initial commit $$

## Do not forget to attach a link to your repo in results.
[Link to my repo](https://github.com/anastasiiaafanasieva/test-repo-for-HW-3).

Done:)
