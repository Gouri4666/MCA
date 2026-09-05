#print even numbers ultil 237 reach in list
l=list(map(int,input("Enter numbers: ").split(" ")))
if l:
    for i in l:
        if i==237:
            break
        elif i%2==0:
            print(i,end=" ")
