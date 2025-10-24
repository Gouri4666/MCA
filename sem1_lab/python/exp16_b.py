#check an item available in list
l=input("Enter list: ").split(" ")
key=input("Enter key: ")
if key in l:
    print("Available")
else:
    print("Not available")