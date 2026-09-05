#enter 2 list of numbers and check they equals to their sum
l1=list(map(int,input("Enter list 1: ").split(",")))
l2=list(map(int,input("Enter list 2: ").split(",")))
s1=0
s2=0
for i in l1:
    s1+=i
for j in l2:
    s2+=j
if s1==s2:
    print("Equal sum")
else:
    print("Not equal")
