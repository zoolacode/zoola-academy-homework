# Task 4

My script:
```sh
#!/bin/bash

num=$(cat result.json | jq '.messages | length') #number of messages
i=0 #counter

while [ $i -lt $num ]
do
    text_message=$(cat result.json | jq '.message['$i'].text') 
    #"message" from our .json is an array 
    #so we're accessing the "text" from the message at index i
    echo $text_message
    i=$(($i + 1)) #change counter values
done
```
