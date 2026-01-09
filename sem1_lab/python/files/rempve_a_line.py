f1=open("file1.txt","r")
lines=f1.readlines()
f1.close()
pos=int(input("Enter position: "))
length=len(lines)
if pos<=0 or pos>length:
    print("Invalid ")
else:
    lines.pop(pos-1)
    f1=open("file1.txt","w")
    f1.writelines(lines)
    f1.close()

