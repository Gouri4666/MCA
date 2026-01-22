class Parent:
    def __init__(self,name,age):
        self.name=name
        self.age=age
    def display(self):
        print(self.name)
        print(self.age)
class Child(Parent):
    def __init__(self,name,age,course):
        super().__init__(name,age)
        self.course=course
    def display(self):
        super().display()
        print(self.course)
c1=Child("gouri",22,"MCA")
c1.display()

    
