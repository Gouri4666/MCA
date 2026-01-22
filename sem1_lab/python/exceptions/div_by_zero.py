try:
    a=int(input("Enter number 1: "))
    b=int(input("Enter number 2: "))
    c=a/b
except ZeroDivisionError as e:
    print(e)
else:
    print("Result: ",c)
finally:
    print("Program executed")