#remove all odd indexed characters
l=input("Enter characters: ").split(" ")
res=l[1::2]
print("Result: ",end="")
for item in res:
    print(item,end=" ")