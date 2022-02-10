# Task 3: Use your imagination

- In branch hw-02-0-anatolii-kravchenko add changes to the file, and save it.
git add .
git commit -m "Add text to the line 11"
- Create a new branch with another content
git checkout -b "demo-content"
git add .
git commit -m "Add content in line 12"
- Go one step back to create another branch demo-content-variant-2
git checkout hw-02-0-anatolii-kravchenko
- Add changes in the text file and save it
- Swich back to the branch hw-02-0-anatolii-kravchenko and rebase to the branch demo-content-variant-2
git rebase demo-content-variant-2
- Add next changes to the text file and save the file.
git add .
git commit -m "Add content to the line 13"
- Merge this branch with the branch demo-content, and resolve conflicts (accept current change).
git merge demo-content
git add .
git commit -m "Resolve conflicts with demo-content branch"
- And, finally, merge this branch into main branch
git merge main

***

tol@tol-VirtualBox:~/Documents/ZA/lesson-3-hw/general/3_git2/Anatolii-Kravchenko$ git log

commit 4f3ff1152211a1c0feb58e9f4f937b8a1280b2f3 (HEAD -> demo-content-variant-2)
Merge: 4a0ceda 97989ca
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Thu Feb 10 10:04:13 2022 +0200

    Resolve conflicts with demo-content branch

commit 4a0cedaddf10c2d55ceb13ff62874ededf845db8
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Thu Feb 10 10:00:43 2022 +0200

    Add content to the line 13

commit 921dbf7e24bb61a156999fd2b3aba8f8c64d7af6
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Thu Feb 10 09:43:50 2022 +0200

    Add concurrent changes in line 12

commit 97989ca36afdf89419febb21a728a922e108122b (demo-content)
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Thu Feb 10 09:37:18 2022 +0200

Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Wed Feb 9 20:43:30 2022 +0200

    Add text at the sixth line

commit cfbd71742a413d04f9bf385c0ec4f138e39a4b32 (origin/hw-02-0-anatolii-kravchenko)
Merge: 5ec8827 4d8c459
Author: Anatolii Kravchenko <anatoliy.kravchenko1991@gmail.com>
Date:   Wed Feb 9 20:30:53 2022 +0200

    Resolved third conflict
