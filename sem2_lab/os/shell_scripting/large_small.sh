#!/bin/bash
if [ $# -eq 0 ]
then
  echo "Usage: $0 num1 num2 num3 ..."
  exit 1
fi
largest=$1
smallest=$1
for num in "$@"
do
  if [ $num -gt $largest ]
  then
    largest=$num
  fi
  if [ $num -lt $smallest ]
  then
    smallest=$num
  fi
done
echo "Numbers: $@"
echo "Largest number: $largest"
echo "Smallest number: $smallest"
