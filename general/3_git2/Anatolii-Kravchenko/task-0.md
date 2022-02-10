- Created new public repo in GitHub with name hometask-repository
- Added remote repo via next commands:
    echo "# hometask-repository" >> README.md
    git init
    git add README.md
    git commit -m "first commit"
    git branch -M main
    git remote add origin git@github.com:tol8901/hometask-repository.git
    git push -u origin main
- Created new branch
    git checkout -b hw-02-0-anatolii-kravchenko
- Created text file with your name and surname
    touch Anatolii-Kravchenko.txt
- Commited it
    git commit -m "Add text file name-surname"
- Pushed to my branch
    git push -u origin hw-02-0-anatolii-kravchenko
- Make sure your .gitignore file exists
    Added .gitignore file
    Removed all unnecessary files from the repository
    touch .gitignore
    git add .
    git commit -m "Remove unnecessary files and create .gitignore file"
    git push -u origin hw-02-0-anatolii-kravchenko
- Show the git logs.

***********************************************************************************************

tol@tol-VirtualBox:~/Documents/ZA/lesson-3-hw/general/3_git2/Anatolii-Kravchenko$ git log
commit 75b781b45f42fe1b62eb53b23981d206415d65b5 (HEAD -> hw-02-0-anatolii-kravchenko, origin/hw-02-0-anatolii-kravchenko)
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Wed Feb 9 11:36:58 2022 +0200

    Remove unnecessary files and create .gitignore file

commit 4c68327cd7ef6fec668be17b0a192672cd3043e0
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Wed Feb 9 11:28:04 2022 +0200

    Add text file name-surname

commit 543242d97fe2e9f3debdfc78f4a8ae784a7407a6
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Wed Feb 9 11:20:48 2022 +0200

    Revert "first commit"
    
    This reverts commit 868bbbcd631d807158498c624262ba00ca123b79.

commit e64bd6245d0631f3694b80362ea261c413248ad7
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Wed Feb 9 11:12:33 2022 +0200

    Add text file name-surname

commit 868bbbcd631d807158498c624262ba00ca123b79 (origin/main, main)
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Wed Feb 9 10:46:36 2022 +0200

    first commit
****************************************************************************************************
A link to my repo:
https://github.com/tol8901/hometask-repository