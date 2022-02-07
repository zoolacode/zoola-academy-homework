### Before you begin

For most of these, you are going to have to look stuff up. 

Such is the life of software engineers! Google things, ask each other, ask me or other mentors.

### Tasks

#### Task 0
Install `git`, we are going to need it for further lectures. Type `git` in shell, if it says something about it being not found, then it isn't installed. Usually, to install programs on Unix systems a package manager is used. Google "install git ___my OS___". If you encounter any errors, google them too.

#### Task 1

Create a bunch of files using `touch`. Output the names of those that have `zoola` in their names.

#### Task 2
Consider the following file:
```sh
slekariev@Z10029 ~ % cat ./mcd.sh
#!/bin/zsh

mkdir -p $1
cd $1
```
And let's say I run
```sh
./mcd nested/dir
``` 
The nested directory is created, but the working directory didn't change. Why?

#### Task 3

Implement a script that would output whether it's a working day or a weekend day. Working days are Monday to Friday, and weekends are Saturday to Sunday. If it's a working day, it should output "Looks like ___number of the current day___ is a working day\weekend". For example, I'm writing this on 6th of January, which is a Thursday. In my case, it should output `Looks like 6 is a working day`, but if I were to run it on Saturday, it would say `Looks like 8 is a weekend`.

#### Task 4

During the lecture, we talked about `jq`, which is useful for parsing JSON files.
Telegram allows to export chat data in the JSON format, and it looks like so:
```
{
 "name": "Group name",
 "type": "private_group",
 "id": 1111,
 "messages": [
  {
   "id": 01,
   "type": "message",
   "date": "2021-03-05T17:36:33",
   "from": "Author-1",
   "from_id": "user1111",
   "text": "text of the message"
  },   {
   "id": 01,
   "type": "message",
   "date": "2021-03-05T17:36:33",
   "from": "Author-2",
   "from_id": "user2222",
   "text": "text of some other message"
  }
 ]
}
```

Use `jq` to output only the texts of the message, stripping all of the other data down. 
If you have Telegram installed, you can export the message from one of your groups. If you'd rather not do that, you can use the prompt that I've provided above.

