#create single string from 2 strings with space by swapping the characters at positon 1
s1=input("enter string 1: ")
s2=input("enter string 2: ")
if s1 and s2:
    res=s2[0]+s1[1:]+" "+s1[0]+s2[1:]
    print(res)
else:
    print("invalid input")
