#constructor with inheritance
class Parent:
    def __init__(self):
        print("Parent class")
class Child(Parent):
    def __init__(self):
        super().__init__()
        print("Child class")
c1=Child()