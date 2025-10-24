#fibonacci
n=int(input("Enter a number: "))
a,b=0,1
if n==0:
    print(a)
elif n>=1:
    print(a,",",b,end=" ")
    for i in range(3,n+1):
        a,b=b,a+b
        print(",",b,end="")
    print("\nlast number: ",b)
else:
    print("Invaid input")