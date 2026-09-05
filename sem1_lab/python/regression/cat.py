import re
with open("text.txt","r") as f:
    contents=f.read()
print(contents)
res=re.findall(r'\bcat\w*',contents)
print("Result: ")
print(res)