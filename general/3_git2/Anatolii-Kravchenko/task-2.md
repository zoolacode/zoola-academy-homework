# Integrate changes from one branch into another branch using:

1. git merge.
    - Add changes to the text file in branch hw-02-0-anatolii-kravchenko, and save the file
    git add .
    git commit -m "Add text at the sixth line"
    git checkout main
    git merge hw-02-0-anatolii-kravchenko

2. git rebase.
    - Add some changes to the text file in branch hw-02-0-anatolii-kravchenko, and save the file
    git checkout hw-02-0-anatolii-kravchenko
    git rebase main

# Questions:

1. Which command did you like the most?
    - I did like the most the merge command. Because it is more safe for work with public repos, and it saves traceability of changes.

2. In which cases it is better to use git merge and when git rebase?
    - Git merge is better to use with public repositories. When there are other people who work on the main branch. When the traceability of changes makes difference.
    - Git rebase is good to use in case of work with local repository. Thic commans allows to make a linear branch and clear commits history.
