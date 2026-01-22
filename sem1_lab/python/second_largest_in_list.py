#Find the second largest element in a list.

l=list(map(int,input("Enter list: ").split(" ")))
new=list(set(l))
print(new)
print("Second largest: ",new[-2])

