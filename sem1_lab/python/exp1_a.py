#replace all occurance of first chracter with $ except first character
s=input("Enter a string: ")
if s:
    res=s[0]+s[1:].replace(s[0],"$")
    print(res)