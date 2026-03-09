#!/bin/bash
echo "Enter a number:"
read n
if [ $((n%2)) -eq 0 ]
then
	echo "$n is even"
else
	echo "$n is odd"
fi
sum=0
for (( i=0;i<=n;i++ ))
do
	sum=$((sum+i))
done
echo "Sum of $n natural numbers:$sum"
