#enter 2 list of integer and check of same length
l1=list(map(int,input("Enter list 1 of numbers sepertaed by comma: ").split(",")))
l2=list(map(int,input("Enter list 1 of numbers sepertaed by comma: ").split(",")))
if len(l1)==len(l2):
    print("Same length")
else:
    print("Different length")