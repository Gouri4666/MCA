from my_packages.number_operation import add,minus
from my_packages.string_operation import conc,length

a=int(input("Enter number 1: "))
b=int(input("Enter number 2: "))
print("Add: ",add(a,b))
print("Difference: ",minus(a,b))

s1=input("Enter a string: ")
s2=input("Enter a string: ")

print("Concatenation of sring: ",conc(s1,s2))
print("Length of sting1: ",length(s1))
print("Length of sting2: ",length(s2))



