#find largest word from list
l=input("Enter list seperated by space: ").split(" ")
largest=""
for item in l:
    if len(item)>len(largest):
        largest=item
print("Largest word is:",largest)