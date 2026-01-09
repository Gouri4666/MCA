#modify age
class Student:
    def __init__(self,name,age):
        self.name=name
        self.age=age
        
s1=Student("Gouri",22)
print(s1.age)
s1.age=30
print(s1.age)
