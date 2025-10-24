#leap year
target=int(input("Enter target year: "))
res=[x for x in range(2025,target+1) if (x%4==0 and (x%100!=0 or x%400==0))]
print("leap year: ",end=" ")
for i in res:
    print(i,end=" ")