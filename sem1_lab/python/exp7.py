#compare 2 list entered by user
l1=list(map(int,input("Enter list1: ").split(" ")))
l2=list(map(int,input("Enter list 2: ").split(" ")))
if l1==l2:
    print("same list")
else:
    print("different list")