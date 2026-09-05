#accept a list single digit number as string, concatenate
l=input("Enter list of single digit numbers: ").split(" ")
res=""
for item in l:
    res=res+item
print("Result: ",res)
