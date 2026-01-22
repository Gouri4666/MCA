with open("demo.txt","r") as f1:
    lines=f1.readlines()
print(lines)
lines.sort(key=len,reverse=True)
print(lines)
length=len(lines[0])
for items in lines:
    if len(items)==length:
        print(items)

