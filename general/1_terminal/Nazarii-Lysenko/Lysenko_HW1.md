Task1

![Task1_1](task1_1.png)
![Task1_2](task1_2.png)

Task2

Directory changed for script, but not for terminal. Shell script is completely another
process and “cd” command was executed for it. To check how this works we can run
this code:

mkdir -p $1
cd $1
mkdir -p "test"

./test.sh nested

Script created directory “nested”, changed current directory and created “test”.

![Task2](task2.png)

Task3

File test.sh

  day=$(date +%u)
  dayOfMonth=$( date +%d )
  if [ $day -lt 6 ];
  then
  echo "Looks like $dayOfMonth is a working day"
  else
  echo "Looks like $dayOfMonth is a weekend"
  fi

Task4

![Task4](task4.jpg)
