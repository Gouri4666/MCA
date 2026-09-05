import re
with open("text.txt","r") as f:
    contents=f.read()
print(contents)
#res=re.findall(r'\w+@gmail.com',contents)
res=re.findall(r'[a-zA-Z0-9]+@gmail.com',contents)

print("Result: ")
print(res)