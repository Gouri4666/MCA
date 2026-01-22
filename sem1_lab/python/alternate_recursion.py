def alter(l):
    if not l:
        return ""
    else:
        return l[0]+" "+alter(l[2:])

l=input("enter list: ")
print("res: ",alter(l))