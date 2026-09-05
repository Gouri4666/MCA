with open("demo.txt","r") as f1:
    contents=f1.readlines()
if contents:
    for item in contents:
        print(item,end="")
