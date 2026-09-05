#vowels from a word
s=input("Enter a string: ")
s=s.lower()
print("Vowels: ")
res=[x for x in s if x=='a' or x=='e' or x=='i' or x=='o' or x=='u']
for i in res:
    print(i,end=" ")