import re
with open('phone.txt',"r") as f1:
    contents=f1.read()
emails=re.findall(r'\b[a-zA-Z0-9.-_+%&#]+@gmail\.com\b',contents)
for items in emails:
    print(items)