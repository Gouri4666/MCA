def rev(l):
    if not l:
        return ""
    else:
        return l[-1]+" "+rev(l[:-1])

l=input("enter list: ").split(" ")
print("res: ",rev(l))