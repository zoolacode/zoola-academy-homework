
1.git merge.
![alt text](https://github.com/[4Pavlo2]/[Pavlo_Shkoropad_HW2_GiT#2]/blob/[main]/st1.png?raw=true)
`git checkout -b feature`
`git merge main`

2.git rebase.
![alt text](https://github.com/[4Pavlo2]/[Pavlo_Shkoropad_HW2_GiT#2]/blob/[main]/st2.png?raw=true)
`git checkout feature`
`git rebase main`

 + + ===================================================================== + +
extra job in real life , real task)
git rebase origin/Pavlo_Shkoropad_lection_1_TERMiNAL

needed rebase from branch Pavlo_Shkoropad_lection_1_TERMiNAL
to branch origin/Pavlo_Shkoropad_HW2_GiT#2
![alt text](https://github.com/[4Pavlo2]/[Pavlo_Shkoropad_HW2_GiT#2]/blob/[main]/real-rebase-real-task.jpeg?raw=true)


 + + ====================================================================== + +
 CONCLUSION : )
git rebase origin - realy useable comand , so I liked it)

Short Version
Merge takes all the changes in one branch and merges them into another branch in one commit.
Rebase says I want the point at which I branched to move to a new starting point
So when do you use either one?

Merge
Let's say you have created a branch for the purpose of developing a single feature. When you want to bring those changes back to master, you probably want merge (you don't care about maintaining all of the interim commits).
Rebase
A second scenario would be if you started doing some development and then another developer made an unrelated change. You probably want to pull and then rebase to base your changes from the current version from the repository.