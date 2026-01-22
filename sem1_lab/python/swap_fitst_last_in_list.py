#Swap the first and last elements of a list.
l=input("Enter list: ").split(" ")
print("List in after swapping: ",end=" ")
l[0],l[-1]=l[-1],l[0]
print("List: ",l)

