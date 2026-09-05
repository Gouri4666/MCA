#Remove duplicate elements from a list.
l=input("Enter list: ").split(" ")
new=[]
for item in l:
    if item not in new:
        new.append(item)
print("List: ",new)
