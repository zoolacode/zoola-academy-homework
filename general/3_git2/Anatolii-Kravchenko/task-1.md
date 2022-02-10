- Made a change in file Anatolii-Kravchenko.txt (add "Hello") in branch hw-02-0-anatolii-kravchenko. Don't pull this change into remote repository yet.
    Anatolii-Kravchenko
    
    git commit -m "Add change to the text file"
- In branch main deleted README.md file and created text file, with different changes.
    
    git add .
    
    git commit -m "Remove Readme file, add text file"

1. First time – accept local changes instead of remote.
    git checkout hw-02-0-anatolii-kravchenko
    git merge main
        <<<<<<< HEAD
        Hello
        =======
        Good morning
        >>>>>>> main
    
    - In VS Code choose "Accept current change" option.
        
        Hello
    
    - Save the file
    
    git add .
    git commit -m "Resolve first conflict"
    git push

2. Second time – accept remote changes instead of local.
    - Made changes in text file in branch hw-02-0-anatolii-kravchenko
    
    git add .
    git commit -m "Add text at second line"
    git push
    git checkout main
    
    - Made changes in text file in branch main
    
    git add .
    git commit -m "Add text in second line"
    
    - Provoke the conflict 
    
    git checkout hw-02-0-anatolii-kravchenko
    git merge main
        
        <<<<<<< HEAD
        Hello
        Nice to meet you!
        =======
        Good morning
        Glad to see you!
        >>>>>>> main
    
    - In VSCode select an option "Accept incoming change"
        
        Good morning
        Glad to see you!
    
    - Save the file
    
    git add .
    git commit -m "Resolve second conflict"
    git push

3. Third time – accept both.
    
    git checkout main
    
    - Made some changes in the text file, save the file
    
    git add .
    git commit -m "Add changes in the third line"
    git push
    git checkout hw-02-0-anatolii-kravchenko
    
    - Made some changes in the text file
    - Save the file
    
    git add .
    git commit -m "Add changes in the third line"
    git push
    git merge main
        
        <<<<<<< HEAD
        Have a nice day!
        =======
        Good bye!
        >>>>>>> main
    
    - In VSCode select "Accept both changes"
        Have a nice day!
        Good bye!
    
    git add .
    git commit -m "Resolved third conflict"    
    
