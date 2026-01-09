#polymorphism
class Dog:
    def sound(self):
        print("Bark")
class Cat:
    def sound(self):
        print("Meow")
d1=Dog()
d1.sound()
c1=Cat()
c1.sound()