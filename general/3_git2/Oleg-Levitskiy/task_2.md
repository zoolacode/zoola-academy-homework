Task_2

I do commits one by one in two different branches

<img width="307" alt="Снимок экрана 2022-02-06 в 17 32 14" src="https://user-images.githubusercontent.com/60513057/152688345-e4d0a4e7-4acd-4f30-9f41-75361ec62d0b.png">

Being on a branch oleg-levitskiy-hw-git-2, do git merge main

<img width="487" alt="Снимок экрана 2022-02-06 в 17 42 40" src="https://user-images.githubusercontent.com/60513057/152688843-c3d82adc-2fbc-43ba-b8a4-152fcdd21dde.png">

Again I make commits one by one in two different branches

<img width="533" alt="Снимок экрана 2022-02-06 в 18 07 13" src="https://user-images.githubusercontent.com/60513057/152689840-ef001787-b75c-41a2-bdbb-08c3e4263642.png">

I switch to the oleg-levitskiy-hw-git-2 branch, do git rebase main, rebase moves all local commits to the top

<img width="536" alt="Снимок экрана 2022-02-06 в 19 03 15" src="https://user-images.githubusercontent.com/60513057/152692292-4e0fe7f2-559b-4a42-9939-e461563c321a.png">

During the execution of Task_2, I continued to use the same branch on which I did Task_1
When I did 'merge' everything was fine, but when I did 'rebase' there was an incomprehensible conflict with the file that I used in Task_1, I suffered for a very long time and could not do anything. As a result, I applied 'rebase --abort' , made Pull requests. And then everything went well from a clean branch. 

merge - safer method, does not spoil the history, but when a large project history is hard to read. 

rebase - With rebase, commits look nice and organized, but rebase is best used only locally and when working on a branch yourself, as there can be problems.

https://github.com/OlegLeva/zoola-exsperiment-hw-git-2
