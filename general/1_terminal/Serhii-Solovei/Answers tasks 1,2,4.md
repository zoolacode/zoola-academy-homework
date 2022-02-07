Task_1: If you wanna find file/files in directory/directories by the name or part of the name - 
	you can use find /way to directory(be default its current directory)/ -name "zoola*".

Task_2: The working directory didn't change because command "cd $1" tries to change current directory on "dir", 
	but there aren't any files with that name. 
	As a result the code runs again and create one more directory with name "dir" inside the created "nested" directory. 
	Flag -p create nested directories, if they don't exist already.

Task_4: I've tried a lot different options, but couldn't get correct result.  
	1) cat ./result.json | jq -r "..|.text?"
	2) cat ./result.json | jq -r ". | .messages | .[] | . | .text"
	In both options the code not working with forwarded messages in Telegram. 
	Forwarded messages are displayed as a separate array.

