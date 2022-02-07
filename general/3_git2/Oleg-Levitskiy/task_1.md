Task_1

1. First time – accept local changes instead of remote.

I make changes in the oleg_levitskiy.txt file on the 'main' branch and make a commit. I switch to the 'oleg-levitskiy-hw-git-2' branch and make changes in the same file and on the same line. When I do 'git merge main' CONFLICT happens.
Using the 'nano oleg_levitskiy.txt' command, open the file for manual editing and leave local changes while removing remote ones.

<img width="816" alt="Снимок экрана 2022-02-06 в 11 41 40" src="https://user-images.githubusercontent.com/60513057/152676685-7d198204-514a-4286-976e-a5ccde87c836.png">
<img width="527" alt="Снимок экрана 2022-02-06 в 11 54 44" src="https://user-images.githubusercontent.com/60513057/152675693-b987a1d8-8ffc-4015-a0a3-ac0e3f20f547.png">
adopted local changes
<img width="543" alt="Снимок экрана 2022-02-06 в 11 55 39" src="https://user-images.githubusercontent.com/60513057/152675714-d88312b1-8382-46f1-baab-c4a1278eeca8.png">

do commit, merge and push

###############################################

2. Second time – accept remote changes instead of local.

I also create a CONFLICT
<img width="868" alt="Снимок экрана 2022-02-06 в 15 54 28" src="https://user-images.githubusercontent.com/60513057/152684216-37201232-33a4-41c9-8a75-cfdb2a68271d.png">

I resolve the conflict with the help of the IDE, click 'Merge conflict resolved' and accept remote changes instead of local ones.

<img width="1205" alt="Снимок экрана 2022-02-06 в 16 15 47" src="https://user-images.githubusercontent.com/60513057/152685454-e07c9d3b-9f04-48e9-9415-9668560c4f79.png">

do commit, push

##############################################

3. Third time – accept both.

I also create a CONFLICT

<img width="553" alt="Снимок экрана 2022-02-06 в 16 40 08" src="https://user-images.githubusercontent.com/60513057/152686295-017d5d2a-0a71-4715-bf76-1e02db9a4f39.png">

I accept both changes.
Place local changes under remote ones.

<img width="542" alt="Снимок экрана 2022-02-06 в 16 41 21" src="https://user-images.githubusercontent.com/60513057/152686364-640c818d-70ff-439f-90af-0acd937267df.png">

do commit, push

https://github.com/OlegLeva/zoola-exsperiment-hw-git-2
