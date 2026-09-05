#increment list by 10% if number >100 alse by 5%
numbers=list(map(int,input("enter list: ").split(" ")))
res=list(map(lambda numbers:numbers+numbers*0.1 if numbers>1000 else numbers+numbers*0.05,numbers))
print(res)