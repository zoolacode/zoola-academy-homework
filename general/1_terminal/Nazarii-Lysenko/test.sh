day=$(date +%u)
dayOfMonth=$( date +%d )
if [ $day -lt 6 ];
then
 echo "Looks like $dayOfMonth is a working day"
else
 echo "Looks like $dayOfMonth is a weekend"
fi

