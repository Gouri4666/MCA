vowels='aeiou'
c=0
s1=input("Enter string: ")
for items in s1:
    if items in vowels:
        c=c+1
print("Count: ",c)