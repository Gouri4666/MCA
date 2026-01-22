with open("demo.txt","r") as f1:
    lines=f1.readlines()
print(lines)
pos=int(input("Enter number of lines: "))
if pos<0 or pos>len(lines):
    print("Invalid position")
else:
    lines.pop(pos-1)
    with open("demo2.txt","w") as f2:
        f2.writelines(lines)