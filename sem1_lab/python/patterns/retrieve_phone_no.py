import re
f=open("phone.txt","r")
contents=f.read()
f.close()
phones=re.findall(r'\b[6]\d{9}\b',contents)
for num in phones:
    print(num)