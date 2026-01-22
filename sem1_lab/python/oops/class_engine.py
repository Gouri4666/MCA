class Engine:
    def __init__(self, power):
        self.__power = power   # private attribute

    def display(self):
        print(f"Engine Power: {self.__power} HP")


class Wheels:
    def __init__(self, size):
        self.__size = size     # private attribute

    def display(self):
        print(f"Wheel Size: {self.__size} inches")


class Car(Engine, Wheels):
    def __init__(self, model, power, size):
        # call base class constructors
        Engine.__init__(self, power)
        Wheels.__init__(self, size)
        self.__model = model   # private attribute

    # Method overriding
    def display(self):
        print(f"Car Model: {self.__model}")
        Engine.display(self)
        Wheels.display(self)


# Example usage
car1 = Car("Tesla Model S", 500, 19)
car1.display()
