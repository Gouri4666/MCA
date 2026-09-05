#print all colors in l1 that are not in l2
l1=input("enter colors list 1: ").split(" ")
l2=input("Enter colors list 2: ").split(" ")
res=set(l1)-set(l2)
print(res)