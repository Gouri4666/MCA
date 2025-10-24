#count number of strings where string lenth is 2 or more and firts and last characters are same
l=input("Enter list: ").split(" ")
for item in l:
    if len(item)>=2 and item[0]==item[-1]:
        print(item,end=" ")