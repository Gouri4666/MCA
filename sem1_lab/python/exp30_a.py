#lambda function to find largest of 2 numbers
largest=lambda x,y:x if x>y else y

a=int(input("Enter a: "))
b=int(input("Enter b: "))
print("Largest: ",largest(a,b))