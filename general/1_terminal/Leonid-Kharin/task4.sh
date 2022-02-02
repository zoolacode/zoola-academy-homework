#!/bin/bash jq

file=$(cat result.json)

echo "please, wait 15 seconds"

# iterate over all keys with value text

for ((i=0; i >(-1); i++)) do 

   text=$(echo $file | jq '.messages'[$i] | jq '.text' ) 

   if [[ $text == "null" ]]; then #  when the list ends the value becomes null
      break
   fi
   
   if [[ $text == *"https"* ]]; then
      temp=10 
   else
       echo $text >> r.json # action that don't matter
   fi

done

echo $(cat r.json) > result.json 
rm r.json