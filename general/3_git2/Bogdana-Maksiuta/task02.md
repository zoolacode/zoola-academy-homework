Task02
First at all I created 2 branches:
❯ git checkout -b first-person-add-title-movie
❯ git checkout main
❯ git checkout -b second-person-add-score-movie

❯ git checkout first-person-add-title-movie
Switched to a branch 'first-person-add-title-movie'
❯ nano new-file.txt
❯ git add .
❯ git commit -m "Add new movies: Hobbit 1 and 2"
[first-person-add-title-movie 421ad92] Add new movies: Hobbit 1 and 2
 1 file changed, 8 insertions(+), 1 deletion(-)

❯ git checkout second-person-add-score-movie
Switched to a branch 'second-person-add-score-movie'
❯ git merge first-person-add-title-movie
Updating 6edc4e4..421ad92
Fast-forward
 new-file.txt | 9 ++++++++-
 1 file changed, 8 insertions(+), 1 deletion(-)
❯ nano new-file.txt
❯ git add .
❯ git commit -m "Add score for 2 movies: The Hobbit 1 and 2"
[second-person-add-score-movie 75752b4] Add score for 2 movies: The Hobbit 1 and 2
 1 file changed, 2 insertions(+), 2 deletions(-)
❯ git checkout first-person-add-title-movie
Switched to branch 'first-person-add-title-movie'
❯ nano new-file.txt
❯ git merge second-person-add-score-movie
Updating 421ad92..75752b4
Fast-forward
 new-file.txt | 4 ++--
 1 file changed, 2 insertions(+), 2 deletions(-)
❯ git merge second-person-add-score-movie
Already up to date.
❯ nano new-file.txt
❯ git add .
❯ git commit -m "Add new movie 'The Hobbit 3'"
[first-person-add-title-movie 1608c61] Add new movie 'The Hobbit 3'
 1 file changed, 3 insertions(+)
❯ git checkout second-person-add-score-movie
Switched to branch 'second-person-add-score-movie'
❯ git checkout first-person-add-title-movie
Switched to branch 'first-person-add-title-movie'
❯ nano new-file.txt
❯ git add .
❯ git commit -m "Add 1 movie "The Lord of The Rings"
dquote> "
error: pathspec 'Lord' did not match any file(s) known to git
error: pathspec 'of' did not match any file(s) known to git
error: pathspec 'The' did not match any file(s) known to git
error: pathspec 'Rings
' did not match any file(s) known to git
❯ git commit -m "Add 1 movie 'The Lord of The Rings 1'"
[first-person-add-title-movie 93bad3b] Add 1 movie 'The Lord of The Rings 1'
 1 file changed, 11 insertions(+)
❯ nano new-file.txt
❯ git add .
❯ git commit -m "Add 1 movie 'The Lord of The Rings 2' "
[first-person-add-title-movie fb69c14] Add 1 movie 'The Lord of The Rings 2'
 1 file changed, 1 insertion(+), 1 deletion(-)
❯ git log
❯ git checkout second-person-add-score-movie
Switched to branch 'second-person-add-score-movie'
❯ git merge first-person-add-title-movie
Updating 75752b4..fb69c14
Fast-forward
 new-file.txt | 14 ++++++++++++++
 1 file changed, 14 insertions(+)
❯ git log
❯ nano new-file.txt
❯ git add .
❯ git commit -m "Add score for The Hobbit 3"
[second-person-add-score-movie d689ddc] Add score for The Hobbit 3
 1 file changed, 1 insertion(+), 1 deletion(-)
❯ nano new-file.txt
❯ git add .
❯ git commit -m "Add score for The Lord of the Rings 1"
[second-person-add-score-movie da64d6a] Add score for The Lord of the Rings 1
 1 file changed, 1 insertion(+), 1 deletion(-)
❯ nano new-file.txt
❯ git add .
❯ git commit -m "Add score for The Lord of the Rings 2"
[second-person-add-score-movie e4ed428] Add score for The Lord of the Rings 2
 1 file changed, 1 insertion(+), 1 deletion(-)
❯ git log
❯ 
❯ git checkout first-person-add-title-movie
Switched to branch 'first-person-add-title-movie'
❯ git log
❯ git rebase second-person-add-score-movie
First, rewinding head to replay your work on top of it...
Fast-forwarded first-person-add-title-movie to second-person-add-score-movie.
❯ git log

My 1st answer.
When I work alone, I more like merge. For now, it’s more simple to understand where I am, where I have some changes, and all my history of commits. 

My 2nd answer.
In short, 
merge is cool for situations where I work on my branch not alone. It’s not confusing commits history and all my commits I can see in order on our branch. 
Or when I have created a branch for the single feature. When I want to bring those changes back to master, I’ll merge them. It’s not about keeping all of the interim commits.
But it can be difficult to understand “who is who” when a lot of people work on this project with their own branches. it will be similar to a picture of the Tokyo subway.

Rebase keeps clean history. It’s more comfortable to work with this command in a big company, where every person has their own branches. 
For ex., then another developer made an unrelated change. And I will rebase to base my changes from the current version from the repository.
