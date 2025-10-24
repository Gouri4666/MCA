#generate square from list
l=list(map(int,input("enter list: ").split(" ")))
res=[x*x for x in l]
print("Squares: ",end=" ")
for i in res:
    print(i,end=" ")