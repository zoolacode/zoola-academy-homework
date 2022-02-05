touch zoola1.txt
touch zoola2.txt
touch zoola3.txt
touch zoom.txt
touch hello.txt
touch hizoola.txt

set -e

arr=$(ls)
for i in $arr; do
   if [[ $i == *"zoola"* ]]
   then
       echo $i
    fi
done


rm zoola1.txt
rm zoola2.txt
rm zoola3.txt
rm zoom.txt
rm hello.txt
rm hizoola.txt
