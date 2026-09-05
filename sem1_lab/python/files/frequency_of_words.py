with open("demo.txt","r") as f1:
    contents=f1.read().lower().split()
print(contents)
f={}
for items in contents:
    if items in f:
        f[items]+=1
    else:
        f[items]=1
for word,count in f.items():
    print(f"{word}:{count}")

