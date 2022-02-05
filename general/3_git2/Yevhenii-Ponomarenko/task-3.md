# Task 3

## Impress the teacher

Weren't you impressed already? I sure hope you were.

But okay, you want to see something new. You want to dig into the unknown, _push_ into new territories, _pull_ new knowledge from the depths of marvel, _fetch_ everything there is, and _merge_ with it into one and whole. I won't _branch_ out too much and _init_ the tale of new things right away.

### Branch folders

Throughout the task 1 and 2 I have been using branch folders. These are useful when you want to logically group multiple branches together. In this case, I've made folder `competition/`. Other usecases may be things like `feature`, `upstream`, or something even more nested. You may easily end up with branch names like `4.0/feature/bug-reporting/interface`. Do keep in mind that if you have a branch that has a folder it depends on (for example, `competition/main`), you cannot create a branch name of that folder (meaning `competition` cannot be a branch itself). `git` will throw a _ref_ error on you, saying something along the lines of "this folder already exists".

### `git rebase --autosquash`

`git commit` command has an interesting feature called `--fixup`. It allows you to create special commits that can modify the name, the contents of that commit, or both, creating a different commit as the result. The reason it's useful is when you want to change anything somewhere deep in your commit tree. Maybe, just like I did, you forgot to save the file before committing, which left the merge markers inside of a file. Then you realised what had happened and quickly made a "fixup!" commit, but you don't want it to be inside of your working tree, you want it applied to the base commit you fixed up. This will, of course, rewrite the history and make the life of developers who depend on your code a living hell, but what you're gonna do, no one can see what a stupid mistake you've made, right?

To set things up, I will create a separate branch, `competition/rebase-fixup`, which will be made specifically to separate all the changes we've made here and let you explore for yourself how this operation affects commits and their history. Then I will merge all the commits from it, basically creating a copy of that branch with separate commits that we can safely mess around with without worrying that we will lose anything on `competition/main`.

```
$ git switch -c competition/rebase-fixup 4c5bbffe8ced8c9b4a48c7287f3181f098cd4df0
Switched to a new branch 'competition/rebase-fixup'

$ git merge competition/main
Updating 4c5bbff..30e5a37
Fast-forward
 competition/tests-problem-1-sort.json   | 38 ++++++++++++++++++++++++++++++++++++++
 competition/tests-problem-2-search.json | 44 ++++++++++++++++++++++++++++++++++++++++++++
 2 files changed, 82 insertions(+)
 create mode 100644 competition/tests-problem-1-sort.json
 create mode 100644 competition/tests-problem-2-search.json
```

Now our working tree looks something like this.
Notice that both `competition/rebase-fixup` and `competition/main` point at the topmost commit.
```
$ git log

commit 30e5a37ec22d615e521d514340cfcf05dedf30d3 (HEAD -> competition/rebase-fixup, origin/competition/main, competition/main)
Author: Mobby Butcher <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:37:32 2022 +0200

    fixup! Merge tests for competition task 1

commit 5a669e356dcd26409de7a44e0a282966b607d729
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:28:21 2022 +0200

    Merge tests for competition task 2

commit ff3bc3a9263123cde942198c18aa83f75bf8fa66
Author: Competition Organizer 2 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:02:34 2022 +0200

    Create tests for competition task 2

commit cfc8226da7959eba3282a915d5eaefb505f6b5ac
Merge: c93b6ce 04663e2
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:17:28 2022 +0200

    Merge tests for competition task 1

commit c93b6cee78dd8fb27bc256b6af1898ca93b2246d
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:15:04 2022 +0200

    Create tests for competition task 1

commit 04663e294cca883882696f0f5d07d19557f6ee05
Author: Competition Organizer 2 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 00:28:26 2022 +0200

    Create tests for competition task 1

// Output omited for brevity
```

With this in mind, let's rebase our branch at its base to try and squash our "fixup!" commit right where it belongs. And since I'm done with automatic `rebase` (see task-2 for suffering), I will use `-i`/`--interactive` flag. Here's what this command bring us in the editor:

```
$ git rebase -i 4c5bbffe8ced8c9b4a48c7287f3181f098cd4df0

pick c93b6ce Create tests for competition task 1
pick 04663e2 Create tests for competition task 1
pick ff3bc3a Create tests for competition task 2
pick 5a669e3 Merge tests for competition task 2
pick 30e5a37 fixup! Merge tests for competition task 1
```

Eagle-eyed viewer might have noticed already what's amiss. The problem is that the very commit we are trying to fixup is not in the list at all. This has happened because it's a _merge_ commit. `rebase` intentionally omits those, with the logic being that merge commit expects a certain state of both source and target branches. Because `rebase` effectively changes that state right under merge's nose, it is assumed that this merge commit is invalid and you will want to change things up anyway, recreating that merge commit. Fortunately, you can include merge commits into your interactive rebase process with `-r`/`--rebase-merges` flag. Let's do exactly that.

```
$ git rebase -ir 4c5bbffe8ced8c9b4a48c7287f3181f098cd4df0

label onto

# Branch Merge-tests-for-competition-task-1
reset onto
pick 04663e2 Create tests for competition task 1
label Merge-tests-for-competition-task-1

reset onto
pick c93b6ce Create tests for competition task 1
merge -C cfc8226 Merge-tests-for-competition-task-1 # Merge tests for competition task 1
pick ff3bc3a Create tests for competition task 2
pick 5a669e3 Merge tests for competition task 2
pick 30e5a37 fixup! Merge tests for competition task 1
```

Unfortunately, GitLens'es Interactive Rebase Editor doesn't prove to be useful in case of merges, so I was left with manual editing. I've moved the fixup commit to the spot where I expect the merge to happen and then instead of `pick` I used the `fixup` command. Let's see how this goes:
```
label onto

# Branch Merge-tests-for-competition-task-1
reset onto
pick 04663e2 Create tests for competition task 1
label Merge-tests-for-competition-task-1

reset onto
pick c93b6ce Create tests for competition task 1
merge -c cfc8226 Merge-tests-for-competition-task-1 # Merge tests for competition task 1
fixup 30e5a37 fixup! Merge tests for competition task 1
pick ff3bc3a Create tests for competition task 2
pick 5a669e3 Merge tests for competition task 2
```

Note that I have changed the `merge -C` command to `merge -c`, which prompted the dialog to rename the commit. I wasn't sure that the commit name will stay the same, so I erred on the side of caution and asked `git` to let me double-check that. All that was left is to close the file and hope for the best:
```
[detached HEAD 883bba5] Merge tests for competition task 1
 Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
 Date: Sat Feb 5 02:17:28 2022 +0200
Successfully rebased and updated refs/heads/competition/rebase-fixup.
```

And just as that, I've managed to successfully edit a merge commit. Finally. Let's just double-check our logs:
```
$ git log

commit ff49ab965ac64f4d7073e2761e32aa6f935cfbcf (HEAD -> competition/rebase-fixup)
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:28:21 2022 +0200

    Merge tests for competition task 2

commit 2ff27a4a9541d6cdff58f23089341fa85f5b3dd1
Author: Competition Organizer 2 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:02:34 2022 +0200

    Create tests for competition task 2

commit 995768a7df81589302aa4ab4de43252d4df678cb
Merge: c93b6ce 04663e2
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:17:28 2022 +0200

    Merge tests for competition task 1

commit c93b6cee78dd8fb27bc256b6af1898ca93b2246d
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:15:04 2022 +0200

    Create tests for competition task 1

commit 04663e294cca883882696f0f5d07d19557f6ee05
Author: Competition Organizer 2 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 00:28:26 2022 +0200

    Create tests for competition task 1

// Output omited for brevity
```

Awesome! Looks like our fixup was applied successfully. Notice how bottommost two commits have the same hash, but the merge and beyond have their hashes updated to reflect the changes that had happened due to our rebase. With that all that's left to do is to publish our branch and hope that no one was depending on old version anyway.
```
$ git push -u origin competition/rebase-fixup
Enter passphrase for key '/home/mobbutcher/.ssh/id_ed25519': 
Enumerating objects: 18, done.
Counting objects: 100% (18/18), done.
Delta compression using up to 2 threads
Compressing objects: 100% (12/12), done.
Writing objects: 100% (12/12), 1.69 KiB | 866.00 KiB/s, done.
Total 12 (delta 9), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (9/9), completed with 2 local objects.
remote: 
remote: Create a pull request for 'competition/rebase-fixup' on GitHub by visiting:
remote:      https://github.com/MobButcher/ZTA-example-git2/pull/new/competition/rebase-fixup
remote: 
To github.com:MobButcher/ZTA-example-git2.git
 * [new branch]      competition/rebase-fixup -> competition/rebase-fixup
Branch 'competition/rebase-fixup' set up to track remote branch 'competition/rebase-fixup' from 'origin'.
```

Lastly, let's see what `--autosquash` will do. For that I've reset my branch back to the base I started out from, once again merged the `competition/main` into `competition/rebase-fixup`, and ran the same command, but this time with `--autosquash` flag enabled. Here's the interactive rebase command list:

```
$ git reset --hard HEAD~5
HEAD is now at 7239810 Create boilerplate for 1-st competition problem "Implement a sorting alforithm for integers"

$ git merge competition/main
// Successful merge.

$ git rebase -ir --autosquash 4c5bbffe8ced8c9b4a48c7287f3181f098cd4df0

label onto

# Branch Merge-tests-for-competition-task-1
reset onto
pick 04663e2 Create tests for competition task 1
label Merge-tests-for-competition-task-1

reset onto
pick c93b6ce Create tests for competition task 1
merge -C cfc8226 Merge-tests-for-competition-task-1 # Merge tests for competition task 1
fixup 30e5a37 fixup! Merge tests for competition task 1
pick ff3bc3a Create tests for competition task 2
pick 5a669e3 Merge tests for competition task 2
```

Closing the file continued the `rebase`, resulting in a successful operation:
```
Successfully rebased and updated refs/heads/competition/rebase-fixup.
```

Let's see the logs once again to notice if anything's different:
```
$ git log

commit dc38aa923a9a208c3377462edf494e105f3515f1 (HEAD -> competition/rebase-fixup)
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:28:21 2022 +0200

    Merge tests for competition task 2

commit a1b793d746ff8f1659839d9802ee4b92c2ae5aa1
Author: Competition Organizer 2 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:02:34 2022 +0200

    Create tests for competition task 2

commit cec772b3567be81b61c9854fd54fac8a016860a4
Merge: c93b6ce 04663e2
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:17:28 2022 +0200

    Merge tests for competition task 1

commit c93b6cee78dd8fb27bc256b6af1898ca93b2246d
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:15:04 2022 +0200

    Create tests for competition task 1

commit 04663e294cca883882696f0f5d07d19557f6ee05
Author: Competition Organizer 2 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 00:28:26 2022 +0200

    Create tests for competition task 1

// Output trimmed for brevity
```

As we can see, despite the fact that we have same changes made in both scenarios, after the divergence point the hashes are different, which means that our changes are treated as different. Let's see what will happen if we `git pull --no-rebase` everything.

```
$ git pull --no-rebase
// Merge commit rename dialog presented

$ git log

commit 79653045f798d2cb110adbee3ec44b480d804364 (HEAD -> competition/rebase-fixup)
Merge: dc38aa9 ff49ab9
Author: Mobby Butcher <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 14:07:12 2022 +0200

    Merge branch 'competition/rebase-fixup' of github.com:MobButcher/ZTA-example-git2 into competition/rebase-fixup

commit dc38aa923a9a208c3377462edf494e105f3515f1
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:28:21 2022 +0200

    Merge tests for competition task 2

commit a1b793d746ff8f1659839d9802ee4b92c2ae5aa1
Author: Competition Organizer 2 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:02:34 2022 +0200

    Create tests for competition task 2

commit cec772b3567be81b61c9854fd54fac8a016860a4
Merge: c93b6ce 04663e2
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:17:28 2022 +0200

    Merge tests for competition task 1

commit ff49ab965ac64f4d7073e2761e32aa6f935cfbcf (origin/competition/rebase-fixup)
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:28:21 2022 +0200

    Merge tests for competition task 2

// Output trimmed for brevity
```

As you can see, we didn't have any conflicts, but our rebase is stacked on top of existing rebase in the remote branch. What will happen if we instead decided to `--rebase`? Let's see for ourselves:
```
$ git pull --rebase
warning: skipped previously applied commit ff3bc3a
warning: skipped previously applied commit 5a669e3
hint: use --reapply-cherry-picks to include skipped commits
hint: Disable this message with "git config advice.skippedCherryPicks false"
dropping 30e5a37ec22d615e521d514340cfcf05dedf30d3 fixup! Merge tests for competition task 1 -- patch contents already upstream
Successfully rebased and updated refs/heads/competition/rebase-fixup.

$ git status
On branch competition/rebase-fixup
Your branch is up to date with 'origin/competition/rebase-fixup'.

nothing to commit, working tree clean

$ git log

commit ff49ab965ac64f4d7073e2761e32aa6f935cfbcf (HEAD -> competition/rebase-fixup, origin/competition/rebase-fixup)
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:28:21 2022 +0200

    Merge tests for competition task 2

commit 2ff27a4a9541d6cdff58f23089341fa85f5b3dd1
Author: Competition Organizer 2 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:02:34 2022 +0200

    Create tests for competition task 2

commit 995768a7df81589302aa4ab4de43252d4df678cb
Merge: c93b6ce 04663e2
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:17:28 2022 +0200

    Merge tests for competition task 1

commit c93b6cee78dd8fb27bc256b6af1898ca93b2246d
Author: Competition Organizer 1 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 02:15:04 2022 +0200

    Create tests for competition task 1

commit 04663e294cca883882696f0f5d07d19557f6ee05
Author: Competition Organizer 2 <38690257+MobButcher@users.noreply.github.com>
Date:   Sat Feb 5 00:28:26 2022 +0200

    Create tests for competition task 1

// Output trimmed for brevity
```

As we can see, our local rebase was completely thrown out in favor of remote one. This is exactly what we wanted. With that we can say that if you know exactly what happened on the remote and redid the same thing locally, rebasing onto the remote may be a better option overall. But these scenarios are rare to come by and usually people will instead do a new commit to fix their mistakes instead of messing up with history. So this is only useful in two cases:
1. You are making rebases locally and want to fixup some commits before pushing them to remote;
2. The remote you are pushing onto is your own fork that you use to crete Pull Requests into the upstream.

First scenario is exactly what I would imagine for a use case for `fixup!` and `--autosquash`. Second one is unnecessary, because you have the luxury to `push --force` any changes without worrying about anyone piggy-backing from your work anyway, and I would recommend sticking with that. It's easier and less hassle, although discretion is still advised and you still have to know exactly what you're doing.

## Conclusions

- Rebase is nice for local, if you know what you're doing.
- `--autosquash` can be used to apply `--fixup`'s you've created along the way.
- `--rebase-merges` creates a lot of shenanigans in interactive rebase.
- GitLens is unfit for `--rebase-merges`.
- Impressing teachers is hard.
- You can impress teachers without screenshots. Embrace the power of command line.