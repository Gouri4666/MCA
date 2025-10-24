#create listof names and cound names starts with a
l=input("Enter names separated by comma: ").split(",")
count=0
for i in l:
    if i.startswith("a"):
        count+=1
print("Number of names starting with 'a':", count)