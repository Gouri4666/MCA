#search an item in a list and give number of occurance
l=input("Enter list: ").split(" ")
item=input("Enter item: ")
c=0
for i in l:
    if i==item:
        c=c+1
print("count: ",c)
