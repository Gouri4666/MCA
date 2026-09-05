with open('file1.txt','r') as f:
    lines=f.readlines()
lines.sort(key=len,reverse=True)
len1=len(lines[0])
for line in lines:
    if len1==len(line):
        print(line)