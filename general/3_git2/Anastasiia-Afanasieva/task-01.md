# Task 1: Solving conflicts

## Accept local changes instead of remote.
  1. We should move to the main branch `git checkout main`.
  2. Create there a file `choose-favorite-drink.txt` where we will make our conflicts.
  3. Add to the file message `My favorite drink is COFFEE`.
  4. `git add`.
  5. `git commit -m 'Create file for conflicts, select coffee as favorite drink'`.
  6. Create a new branch for conflict `git checkout -b conflict-maker`.
  7. `nano choose-favorite-drink.txt` to modify the file. I will rewrite it `My favorite drink is TEA`.
  8. `git add choose-favorite-drink.txt`.
  9. `git commit -m 'Select tea as favorite drink instead of coffee'`.
  10. Change to the main branch `git checkout main`.
  11. Edit the file by adding also Coca-Cola as a favorite drink. `My favorite drink is COFFEE and Coca-Cola!`.
  12. `git add choose-favorite-drink.txt`.
  13. `git commit -m 'Add Coca-Cola as favorite drink'`.
  14. Merge the branch `conflict-maker` into main to see the error using command `git merge conflict-maker`.
  15. And we see: 
    $$ anastasiiaafanasieva@Anastasiias-MacBook-Air testRepository git merge conflict-maker
Auto-merging choose-favorite-drink.txt
CONFLICT (content): Merge conflict in choose-favorite-drink.txt
Automatic merge failed; fix conflicts and then commit the result.
    $$
  16. Our conflict looks like this:
    <<<<<<< HEAD
    My favorite drink is COFFEE and Coca-Cola!
    =======
    My favorite drink is TEA!
    >>>>>>> conflict-maker
  17. Accept local changes and leave `My favorite drink is TEA!`, `git add`, `git commit`.
  18. `git log` to see our changes:
  $$ anastasiiaafanasieva@Anastasiias-MacBook-Air testRepository % git log
commit cec7ddef45bc7652b20b808f42e9777bbb717674 (HEAD -> main)
Merge: ef1c014 4d00c0a
Author: Anastasiia Afanasieva <anastasiiaafanasieva@Anastasiias-MacBook-Air.local>
Date:   Tue Feb 8 16:49:08 2022 +0200
  Resolve conflict, accept local changes, select tea as favorite drink $$
  19. `git push origin main`.
  20. Result in Github ![local_changes_accepted](https://raw.githubusercontent.com/anastasiiaafanasieva/images/main/local_changes_accepted.png?token=GHSAT0AAAAAABQNRDJZOM7ELSMCL4AOXZWMYQC2WGQ)


## Accept remote changes instead of local.
  1. Go to https://github.com/anastasiiaafanasieva/test-repo-for-HW-3 and modify remotely `choose-favorite-drink.txt`. Change `Tea` to `Water`. I know that it's strictly prohibited to modify smth in main/master branch, it's just for example. 
    ![rename_file_remotely](https://raw.githubusercontent.com/anastasiiaafanasieva/images/main/rename_file_remotely.png?token=GHSAT0AAAAAABQNRDJZRRX2PK5ZX6WFRFDAYQC2WLA)
  2. Switch in Terminal to another branch `git checkout conflict-maker`.
  3. Change `Tea` to `Pina Colada`:).
  4. `git add`, `git commit`.
  5. Change branch to main.
  6. `git pull` to pull changes which we made on the main branch in Github (change `Tea` to `Water`).
  7. `git merge conflict-maker`. We receive conflict: 
  $$ Auto-merging choose-favorite-drink.txt
CONFLICT (content): Merge conflict in choose-favorite-drink.txt
Automatic merge failed; fix conflicts and then commit the result.
  $$
  8. `nano choose-favorite-drink.txt` we see: 
    <<<<<<< HEAD
    My favorite drink is WATER!
    =======
    My favorite drink is Pina-Colada!
    >>>>>>> conflict-maker
  9. As we need to accept remote changes, we leave HEAD `My favorite drink is WATER!`.
  10. `git add`, `git commit`.
  11. Result in Github ![remote_changes_accepted](https://raw.githubusercontent.com/anastasiiaafanasieva/images/main/remote_changes_accepted.png?token=GHSAT0AAAAAABQNRDJZ7ABT5ES2E444NHJ2YQC2WSA)

## Accept both.
  1. In the main branch in Terminal modify our file `choose-favorite-drink.txt`. Add a few drinks as a favorite: `kvas`, `lemonade`, `iced-tea`.
  2. `git add`, `git commit`, `git push origin main`.
  3. Switch to our conflict branch `git checkout conflict-maker` to create conflict.
  4. In the conflicting branch in Terminal modify our file `choose-favorite-drink.txt`. Change the message to: `My favorite drinks are with bubbles`.
  5. `git add`, `git commit`, `git push origin conflict-maker`.
  6. Go to GitHub and see the notification that we `Can’t automatically merge`.
  7. Create a pull request to solve the conflict in Github.
  8. here we see our changes and accept both of them ![both_changes_accepted](https://raw.githubusercontent.com/anastasiiaafanasieva/images/main/both_changes_accepted.png?token=GHSAT0AAAAAABQNRDJYKI2TI42YF33R27A2YQC2WYQ)
  9. Commit merge and merge pull request!
  10. Result in Github ![commits_both_changes](https://raw.githubusercontent.com/anastasiiaafanasieva/images/main/commits_both_changes.png?token=GHSAT0AAAAAABQNRDJZIQGCWYCXWLPQ6JD2YQC2XCA)
