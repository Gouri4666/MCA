import re
with open("text.txt","r") as f:
    contents=f.read()
pattern=r'[0-9]{4}-[0-9]{4}-[0-9]{4}'
res=re.findall(pattern,contents)
for items in res:
    print(items)