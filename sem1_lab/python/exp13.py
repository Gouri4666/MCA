#accept strings and find max length , if more than 1 return BINGO
s=input("Enter a string: ").split(" ")
s.sort(key=len,reverse=True)
print(s)
length=len(s[0])
c=0
for items in s:
    if len(items)==length:
        c=c+1
if(c>1):
    print("BINGO")
else:
    print(length)