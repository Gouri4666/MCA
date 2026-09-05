#Create a class Student with name & age. Print details.
class Student:
    def __init__(self,name,age):
        self.name=name
        self.age=age
    def display(self):
        print("Name: ",self.name)
        print("Age: ",self.age)
s1=Student("Aparna",21)
s1.display()
        