#create listof names and cound names starts with a
l=input("list: ").split(" ")
c=0
for items in l:
    if items.startswith("a"):
        c=c+1
print("Count: ",c)