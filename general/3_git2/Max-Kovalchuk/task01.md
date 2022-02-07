# Task 1: Solving conflicts

1. **Conflict with accept local changes:**

   ![Local changes](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-1.png)

   `git log`:

   ![log](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-2.png)

   GitHub:

   ![conflict GItHub](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-3.png)

   ![changes GitHub](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-4.png)

2. **Conflict with accept remote changes:**

   ![Remote changes](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-5.png)

   ![choose changes](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-6.png)

   `git log`:

   ![log](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-7.png)

3. **Conflict with accept both changes:**

   ![](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-8.png)

   ![](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-9.png)

   ![](/home/maks/zoola-academy-homework/general/3_git2/Max-Kovalchuk/screenshot/task01-10.png)

   

   **git command to use with conflicts**:

   - `git status`
   - `git log --merge` (Passing the --merge argument to the `git log` command will create a log listing commit conflicts between the branches being merged)
   - `git diff`
   - `git reset`
   - `git checkout`
   - `git merge --abort`

### Conclusion

- Git does not provide any graphical merge tools, but will happily work with third party merge tools you wish to use.
- Pull the master into your branch more often, that is, keep the branch up to date. The more outdated your branch is, the more likely it is that there will be many conflicts during the merge.
- Need to push branch after conflict resolution. This is especially important if you are working with a colleague in the same branch. Then, when pulling up the master, only one of you will resolve the conflict. The rest will pull up clean code.