#count odd and even numbers in list
l=list(map(int,input("Enter list: ").split(" ")))
o=0
e=0
for item in l:
    if item%2:
        o+=1
    else:
        e+=1
print("Odd: ",o)
print("Even: ",e)