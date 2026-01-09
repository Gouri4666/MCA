n=int(input("Enter number: "))
f=1
for i in range(2,n):
    if n%i==0:
        f=0
        break
if f:
    print("prime")
else:
    print("Not prime")

