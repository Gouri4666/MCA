#accept full name and dislay in reverse order with space
name=input("Enter name: ").split(" ")
if len(name):
    res=name[::-1]
    print("Name in reverse order: ",end="")
    for item in res:
        print(item,end=" ")