I created new repo in  github, link is : https://github.com/danta-m/za-homework-repo
My steps: Your repositories -> new -> wrote "Name" and "description" -> create repository

After I did all steps from "Github help". These were: 
1. Create Readme.md
echo "# za-homework-repo" >> README.md
2. Start working with git localy
git init
3. Add file README.md
git add README.md
4.Commit it
git commit -m "first commit"
5. Rename master branch to main
git branch -M main
6. Link remote and local repo
git remote add orogon git@github.com:danta-m/za-homework-repo.git
7. Push my local changes to local repository 
git push -u origin main

Created new branch and switched it:
git checkout -b add-file-my-name

Created new text file with my name and surname inside in current directory:
nano my-name.txt
and text inside: Bogdana Maksiuta
ctrl+x -> Y -> enter

Checked git status
git status

I hadn't any unnecessary files, just my-name.txt, so I decided didn't create a file .gitignore . 

I prepared a file for commit (added it)
git add .

and committed:
git commit -m "Add file my-name.txt"

I did a screenshot with my git logs.

I pushed my file to remove repo :
git push -u origin add-file-my-name
Switched to branch 'main'
