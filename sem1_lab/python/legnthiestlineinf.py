f=open('f1.txt')
lines=f.readlines()
lines.sort(key=len,reverse=True)
print("longest line:",lines[0])