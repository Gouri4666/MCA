#Split a list into even and odd lists.
l=list(map(int,input("Enter list: ").split(" ")))
odd=[]
even=[]
for item in l:
    if item%2==0:
        odd.append(item)
    else:
        even.append(item)
print("Odd: ",odd)
print("Even: ",even)

