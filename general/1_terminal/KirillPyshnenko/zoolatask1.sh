#!/bin/sh
name=$1
mkdir -p $name
pwd
cd ./$name
pwd  

# путем анализа этого скрипта
#  путем добавления проверки директории 
# прихожу к выводу  что данная ситуация обьясняется тем, 
# чтоскрипт выполняется внутри оболочки, 
# а при окончании и выходе из файла
#  возвращается в текущую директорию(потому что сам терминал директорию не менял?????)
#  вот копипаста из терминала ниже:
# administrator@administrator-ThinkPad-T470:~/Рабочий стол/NewFolderX/Zoola$ ./zoolatask1.sh Test2
# /home/administrator/Рабочий стол/NewFolderX/Zoola
# /home/administrator/Рабочий стол/NewFolderX/Zoola/Test2
