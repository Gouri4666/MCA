from my_packages import number_operation
from my_packages import string_operation

a=int(input("Enter number 1: "))
b=int(input("Enter number 2: "))
print("Add: ",number_operation.add(a,b))
print("Difference: ",number_operation.minus(a,b))

s1=input("Enter a string: ")
s2=input("Enter a string: ")

print("Concatenation of sring: ",string_operation.conc(s1,s2))
print("Length of sting1: ",string_operation.length(s1))
print("Length of sting2: ",string_operation.length(s2))



