#find largest word from list
l=input("Enter list seperated by space: ").split(" ")
l.sort(key=len,reverse=True)
print(l)
length=len(l[0])
for items in l:
    if len(items)==length:
        print(items)