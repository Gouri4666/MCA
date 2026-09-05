#remove even numbers
l=list(map(int,input("enter list: ").split(" ")))
print("Odd numbers: ",end=" ")
res=[x for x in l if not x%2==0]
for i in res:
    print(i,end=" ")