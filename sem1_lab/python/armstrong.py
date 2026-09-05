def arm(n):
    while n>0:
        rem=n%10
        res+=rem**3
        n=n//10
    return res

n=int(input("Enter number: "))
res=arm(n)
if res==n:
    print("armstrong")
else:
    print("Not armstrong")