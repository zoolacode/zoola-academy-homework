DAY_OF_WEEK=`date +%w`
DAY=`date +%d`

if (( ( $DAY_OF_WEEK == 6 ) || ( $DAY_OF_WEEK == 7 ) )) ; then #(()) =integer variable
  echo "Looks like ${DAY} is a weekend day"
else 
  echo "Looks like ${DAY} is a working day"
fi
