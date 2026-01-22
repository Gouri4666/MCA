with open("demo.txt","r") as f1:
    contents=f1.read().split()
print(contents)
contents.sort(key=len,reverse=True)
print(contents)
length=len(contents[0])
for items in contents:
    if len(items)==length:
        print(items)


