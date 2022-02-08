Task 2: Merge vs Rebase

Integrate changes from one branch into another branch using:

    git merge.
    merged confict-br into master
    image 9-10.png

    git rebase.
    git rebase master
    "Current branch master is up to date."
    rm conffile.txt
    git add .
    git commit -m 'rm confl file'
    Current branch master is up to date.
    image 11.png

    q1
    Which command did you like the most?
    there are not better command. every have reason to be.

    q2
    In which cases it is better to use git merge and when git rebase?
    merge is better to use always if you need join some branch (work in group)
    rebase is great for big changes (example: begin to use old ver)

    conclusion: git have many way to control your data. you just have to make a choice.