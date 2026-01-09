#delete age
class Student:
    def __init__(self,name,age):
        self.name=name
        self.age=age
        
s1=Student("Gouri",22)
print(s1.age)
del s1.age
print(s1.age)
