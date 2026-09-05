#generate square from list
l=list(map(int,input("Enter list: ").split(" ")))
res=[x*x for x in l]
print(res)