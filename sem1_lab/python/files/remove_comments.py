with open("demo.txt","r") as f1:
    lines=f1.readlines()
new=[]
for items in lines:
    if not items.startswith('#'):
        new.append(items)
for items in new:
    print(items,end="")
