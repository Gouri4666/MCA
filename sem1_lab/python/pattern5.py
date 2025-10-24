#* * * * * * 
#* * * * * 
#* * * *
#* * *
#* *
#*

n=5
for i in range(n+1):
    for j in range(n-i+1,0,-1):
        print("*",end=" ")
    print()