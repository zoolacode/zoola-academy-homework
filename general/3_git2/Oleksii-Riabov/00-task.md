Task 0: Setting up remote repo.

1. Create new public repo in GitHub.

1.1. Press "New" button in "Your repositories" section:

![img.png](img.png)

1.2. Set "Repository name" in corresponding field. Following this pattern <"projectKey/team">-<"tech">-<"maturity"> is recommended: 

![img_1.png](img_1.png)

1.3. Select repository visibility as "Public" and click "Create repository":

![img_2.png](img_2.png)

2. Set it up both remote and local.

2.1. Open terminal, select local directory for project and "cd" in it.

2.2. Create README.md and write there information about your project:

![img_5.png](img_5.png)

2.3. Use git init command to initialize current directory and create ".git" file in it:

![img_6.png](img_6.png)

2.4. Add README.md in index and then commit it in local repository. Use "-m" flag to write commit message directly in command line:

![img_7.png](img_7.png)

2.5. Creates a new remote called "origin" located at your remote repository: 

![img_9.png](img_9.png)

2.6. Push the commits from the local branch "master" to the remote "origin" "master":

![img_10.png](img_10.png)

2.7. Create ".gitignore", add there all unnecessary files, make separate commit for ".gitignore" only due to "best practice" recommendations and push it to remote repository:

![img_11.png](img_11.png)

3. Create new branch and checkout on it with "-b" flag for "checkout" command. Following this pattern <"taskID">-<"short-actionable-description-of-what-the-task-is-about-with-hyphens-as-separators"> for brunch creation is recommended:

![img_13.png](img_13.png)

4. Create text file with your name and surname:

![img_15.png](img_15.png)

5. Add it to index and then commit:

![img_16.png](img_16.png)

6. Create remote branch with same name as in you local branch and push your commit to it: 

![img_20.png](img_20.png)

7. Make sure your .gitignore file exists, and you did not push any unnecessary files:

![img_18.png](img_18.png)

8. Show the git logs:

![img_21.png](img_21.png)

9. Attach a link to your repo in results:
   https://github.com/ryaboff99/ZA-git-hw/tree/001-git-hw



