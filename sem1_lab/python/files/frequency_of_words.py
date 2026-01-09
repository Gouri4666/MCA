f=open("file1.txt","r")
words=f.read().lower().split()
f={}
for item in words:
    if item in f:
        f[item]+=1
    else:
        f[item]=1
for word,count in f.items():
    print(f"{word}:{count}")

