# Task 2
## Merge
First we have create new text file in main branch named 'use_merge'.  

```
$ git log
commit 247f771f169b5c6d2a13cfad940d470e17aebef0 (HEAD -> main, git_branch)
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 21:55:38 2022 +0200

    created use_merge file
```
Then we have created new text file in git_branch named 'use_merge_f'.  

```
$ git log
commit e93b1a6aed275eaf76f6bca79fb6d1a4341d9fe5 (HEAD -> git_branch)
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:02:54 2022 +0200

    created use_merge_f file
```

Now we will integrate changes from one branch to another branch using `git merge`.  

```
$ git merge main
Merge made by the 'recursive' strategy.
 use_merge.txt | 1 +
 1 file changed, 1 insertion(+)
```

```
$ git log
commit b1055a4502655412765fd979b8e4d50251b673cf (HEAD -> git_branch)
Merge: e93b1a6 1f58ac0
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:03:53 2022 +0200

    Merge branch 'main' into git_branch

commit e93b1a6aed275eaf76f6bca79fb6d1a4341d9fe5
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:02:54 2022 +0200

    created use_merge_f file

commit 1f58ac0e31a80ffd134f37b5fdb451bf08494c2e (main)
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:01:00 2022 +0200

    added text to main file

commit 247f771f169b5c6d2a13cfad940d470e17aebef0
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 21:55:38 2022 +0200

    created use_merge file
```

## Rebase
First we have create new text file in main branch named 'use_rebase'.  

```
$ git log
commit 247f771f169b5c6d2a13cfad940d470e17aebef0
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 21:55:38 2022 +0200

    created use_merge file
```
Then added some text to main branch file.  

```
$ git log
commit 911a13384339bafadbce97ad26b8a82bf839c878 (HEAD -> main)
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:13:11 2022 +0200

    added some text to use_rebase main
```

Then added some text to git_branch file.  

```
$ git log
commit 56f09e697e9f3d61b687a6c8a640f4c290a07f99 (HEAD -> git_branch)
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:15:11 2022 +0200

    added some text to use_rebase_f git_branch file
```

Then added some more text to mainn branch file again.  

```
$ git log
commit 3368748276b4b75e0e9f53b7be8d4cc9b6e38dc8 (HEAD -> main)
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:17:06 2022 +0200

    added some more text to use_rebase main file
```

Now we will integrate changes from one branch to another branch using `git rebase`.  

```
$ git log
commit b7f2be82b8525b7552769a62a0b702b2775141de (HEAD -> git_branch)
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:15:11 2022 +0200

    added some text to use_rebase_f git_branch file

commit 9705864799ce70da2440dbfffb263f1150b92b73
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:02:54 2022 +0200

    created use_merge_f file

commit 3368748276b4b75e0e9f53b7be8d4cc9b6e38dc8 (main)
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:17:06 2022 +0200

    added some more text to use_rebase main file

commit 911a13384339bafadbce97ad26b8a82bf839c878
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:13:11 2022 +0200

    added some text to use_rebase main

commit bfd2a7413246180ae4a347831da623f976c1c72b
Author: Gamid <g1a6m0i9d@gmail.com>
Date:   Mon Feb 7 22:10:05 2022 +0200

    create use_rebase file in main branch
```

















