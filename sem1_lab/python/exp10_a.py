#determine frequency of alphabets 
a=input("Enter the string to count alphabets: ")
d={}
for i in a:
    if i.isalpha():
        if i in d:
            d[i]+=1
        else:
            d[i]=1
print("Frequency of alphabets in the given string is: ")
for k,v in d.items():
    print(k,":",v)
