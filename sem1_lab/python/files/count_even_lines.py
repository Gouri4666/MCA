with open("demo.txt","r") as f:
    contents=f.readlines()
print(contents)
print("Even position: ")
for i in range(0,len(contents),2):
    print(contents[i],end="")