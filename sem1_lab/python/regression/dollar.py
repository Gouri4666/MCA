import re
with open("text.txt","r") as f:
    contents=f.read()
pattern=r'[$]\d+\.?\d*'
res=re.findall(pattern,contents)
if res:
    for items in res:
        print(items)
else:
    print("empty")