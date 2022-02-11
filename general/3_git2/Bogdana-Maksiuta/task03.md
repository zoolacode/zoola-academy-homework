git checkout branch-for-conflict  // my old branch which I merged
nano cherry.txt // create file with name cherry.txt and open it.
Add text to the file :
Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book
save and exit

git add .    
git commit -m “create file and add some text to it”
All changes were saved to the local git storage 

nano cherry-2.txt 
Add text to the file :
It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum
save and exit

git add .    
git commit -m “create file 2 and add some text to it”
All changes were saved to the local git storage.

nano cherry-3.txt 
Add text to the file :
IContrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.

save and exit
git add .    
git commit -m “create file 2 and add some text to it”
All changes were saved to the local git storage.

git log (pic 3.1)
git checkout main // I saw that I was on wrong branch. And I need file and file2 on my new branch
git checkout -b branch-for-cherry-pick
git cherry-pick 590d154df3eec113cc5b06d890b72fccd27c17d3
    create file and add some text to it
git cherry-pick 2c1873d3be28495f3fe4b739e7f1db97692a90ce
    create file 2 and add some text to it

git log (pic 3.2)
git file-for-delete.md
git add .
git commit -m "Add new file 'file-for-delete.md'"
[branch-for-cherry-pick febb458] Add new file 'file-for-delete.md'
 1 file changed, 1 insertion(+)
 create mode 100644 file-for-delete.md

git revert febb4584d68d5509273d5c49dceebc5a5669bdd5
Removing file-for-delete.md
[branch-for-cherry-pick 927bc5f] Revert "Add new file 'file-for-delete.md'"
 1 file changed, 1 deletion(-)
 delete mode 100644 file-for-delete.md
(pic 3.3)
