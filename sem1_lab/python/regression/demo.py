import re
with open("text.txt","r") as f1:
    contents=f1.readlines()
x="explain"
print(contents)
pattern=r'explain'
for items in contents:
    if re.search(pattern,items):
        print(items)