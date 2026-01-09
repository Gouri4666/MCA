#create file and write
# f=open("file1.txt",'w')
# f.write("Hello!")
# f.close()

#read file
# f=open("file1.txt","r")
# content=f.read()
# print(content)
# f.close()

#append to file
# f=open("file1.txt","a")
# f.write("World!")
# f.close()

#append new line
# f=open("file1.txt","a")
# f.write("\nThe first line")
# f.close()

#read line by line
# f=open("file1.txt","r")
# for line in f:
#     print(line)
# f.close()

#read lines as list
# f=open("file1.txt","r")
# l=f.readlines()
# print(l)

#tell()-current position of cursor, seek()-move back to position
# f=open("file1.txt","r")
# print(f.tell())
# print(f.read(10))
# print(f.tell())
# f.seek(0)
# print(f.tell())