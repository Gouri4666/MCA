import re
password=input("Emter password: ")
pattern=r'^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[/*@!$%&]).{8,}$'
if re.fullmatch(pattern,password):
    print("valid password")
else:
    print("Not valid")