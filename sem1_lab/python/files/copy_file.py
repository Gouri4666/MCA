with open('file1.txt','r') as f1:
    contents=f1.read()
with open('file2.txt','w') as f2:
    f2.writelines(contents)