# f=open("file1.txt","r")
# lines=f.readlines()
# c=0
# for line in lines:
#     c=c+1
# print("Lines: ",c)
with open("file1.txt","r")as f:
    lines=f.readlines()
print(len(lines))