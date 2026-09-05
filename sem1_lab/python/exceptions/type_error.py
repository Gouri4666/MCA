try:
    x=input("Enter a character: ")
    c=10/x
except TypeError:
    print("Type error occured, integer cant divided by string")
else:
    print(c)
finally:
    print("Exit..")
