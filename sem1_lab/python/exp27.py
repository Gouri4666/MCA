#count number of strings where string lenth is 2 or more and firts and last characters are same
n=input("Enter string: ")
c=0
if len(n)>2 and n[0]==n[-1]:
    for items in n:
                c=c+1
print("Count: ",c)