#Task 4
#!/bin/bash

jq ".messages[].text" result.json

# This JSON object contains an array called 'Mesages'.
#It’s an array of objects that each contain many key:value pairs such as 'text' that we need.
#We can retrieve the name of a single object if we put its position in the array in the brackets ([]) on the command line.


