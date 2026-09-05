with open("demo.txt","r") as f:
    lines=f.readlines()
    c=0
for line in lines:
    c+=1
print(c)