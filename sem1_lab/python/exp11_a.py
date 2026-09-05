# make all positive inegers 
l=list(map(int,input("Enter list : ").split(" ")))
res=[x for x in l if x>0]
print(res)