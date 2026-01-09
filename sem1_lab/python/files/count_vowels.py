f=open("file1.txt","r")
contents=f.read().lower()
vowels="aeiou"
c=0
for item in contents:
    if item in vowels:
        c=c+1
print("Count: ",c)