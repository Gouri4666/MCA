l1 = input("List 1: ").split(" ")
f={}
for items in l1:
    if items in f:
        f[items]+=1
    else:
        f[items]=1
for k,v in f.items():
    print(f"{k}:{v}")

