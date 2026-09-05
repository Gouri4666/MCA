s=input("Enter a string: ")
if len(s)==2:
    res=s+s
    print(res)
elif len(s)<2:
    print(" ")
else:
    res=s[:2]+s[-2:]
    print(res)
