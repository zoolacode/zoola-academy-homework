# Task 0: Setting up remote repo

I created a new public repository in GitHub through a web interface.
To set it up both remote and local, I used these commands:
~~~
echo "# hw2git" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:yaroslav-dzhur/hw2git.git
git push -u origin main
~~~
---
Creating new branch:
~~~
git checkout -b hw-personal-data
~~~
---
Creating text file with my name and surname:
~~~
echo yaroslav dzhur > myname.txt
~~~
---
Commiting and pushing my branch:
~~~
git add .
git commit -m "Added my name and surname"
git push origin -u hw-personal-data
~~~
---
Git log:
~~~
commit edbd8c7269fb98894122c6358eb8e1f5620c6947 (HEAD -> hw-personal-data, origin/hw-personal-data)
Author: Yaroslav Dzhur <yaroslav.dzhur@gmail.com>
Date:   Fri Feb 11 18:00:43 2022 +0200

    Added my name and surname

commit e15d149611a27326f84e2d5430fa18f81c34c14d (origin/main, main)
Author: Yaroslav Dzhur <yaroslav.dzhur@gmail.com>
Date:   Fri Feb 11 17:27:41 2022 +0200

    first commit
~~~
---
##### Described repo [hw2git](https://github.com/yaroslav-dzhur/hw2git/)
