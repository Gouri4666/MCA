def rev(l):
    if not l:
        return []
    else:
        return [l[-1]]+rev(l[:-1])
l=list(map(int,input("enter list: ").split(" ")))

print("Reverse: ",rev(l))