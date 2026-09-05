with open("demo.txt","r") as f1:
    contents=f1.readlines()
with open("demo2.txt","w") as f2:
    f2.writelines(contents)
