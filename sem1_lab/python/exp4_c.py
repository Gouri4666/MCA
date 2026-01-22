#2 list of numbers and check any value occur in both
l1=list(map(int,input("Enter list 1: ").split(",")))
l2=list(map(int,input("Enter list 2: ").split(",")))
l1=set(l1)
l2=set(l2)
if l1 & l2:
    print("same element")
else:
    print("No same lement found")