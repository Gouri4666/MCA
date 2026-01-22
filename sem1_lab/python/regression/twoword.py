import re

with open("text.txt", "r") as f:
    lines = f.readlines()

pattern = r'\w+[aeiou]+\s+[aeiou]\w+'

for line in lines:
    line=line.strip()
    if re.findall(pattern, line):
        print(line)
