##list elements with values greater than 100
l=list(map(int,input("Enter list: ").split(" ")))
res=[x for x in l if x>100]
print(res)