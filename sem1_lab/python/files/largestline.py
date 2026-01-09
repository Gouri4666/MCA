f=open("file1.txt","r")
lines=f.readlines()
lines.sort(key=len,reverse=True)
print(lines[0])