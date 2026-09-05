#count Words i na text
l=input("enter a line: ").split(" ")
f={}
for items in l:
    if items in f:
        f[items]+=1
    else:
        f[items]=1
for k,v in f.items():
    print(f"{k}:{v}")