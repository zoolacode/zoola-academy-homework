#Task 2
#!/bin/bash

#I think that you need to use function(), and your code will look like this:

function mkcd(){
  mkdir $1
  cd $1
}

#or

mkdircd(){ mkdir "$1" && cd "$1" ; }
