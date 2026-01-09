with open('file1.txt','r') as f1:
    lines=f1.readlines()
for i in range(0,len(lines),2):
    print(lines[i])