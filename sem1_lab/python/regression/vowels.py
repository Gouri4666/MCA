import re
with open("text.txt","r") as f:
    contents=f.read()
pattern=r'\b[aeiou]+\w+[^aeiou]\b'
res=re.findall(pattern,contents)
if res:
    for items in res:
        print(items)
else:
    print("empty")