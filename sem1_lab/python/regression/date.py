import re
with open("text.txt","r") as f:
    contents=f.read()
res=re.findall(r'[0-9]{2}[/-][0-9]{2}[/-][0-9]{2}',contents)
for items in res:
    print(items)