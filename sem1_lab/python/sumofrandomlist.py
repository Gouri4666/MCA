import random
def sumof(list1):
    if list1:
        return list1[0]+ sumof(list1[1:])
    else:
        return 0
list1=[]
for i in range(10):
    list1.append(random.randint(1,100))
print(list1)
print("sum: ",sumof(list1))