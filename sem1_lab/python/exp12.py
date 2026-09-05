#add ing to end if already present add ly
a=input("Enter a string: ")
if a.endswith("ing"):
    print(a[::]+'ly')
else:
    print(a[::]+"ing")