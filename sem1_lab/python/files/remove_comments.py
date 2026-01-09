f=open("file1.txt","r")
lines=f.readlines()
f.close()
new=[]
for item in lines:
    if not item.startswith('#'):
        new.append(item)
f2=open("file1.txt","w")
f2.writelines(new)
f2.close()
    