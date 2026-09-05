f=open("file1.txt","r")
content=f.read()
list1=content.split()
c=0
for words in list1:
    c=c+1
print("count: ",c)