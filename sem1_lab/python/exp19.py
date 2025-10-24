#sum of list
l=list(map(int,input("Enter list of numbers: ").split(" ")))
sum=0
for i in l:
    sum+=i
print("sum: ",sum)
