class Engine:
    def __init__(self, power):
        self._power = power     # protected attribute

    def display(self):
        print("Engine Power:", self._power)


class Wheels:
    def __init__(self, size):
        self._size = size       # protected attribute

    def display(self):
        print("Wheel Size:", self._size)


class Car(Engine, Wheels):
    def __init__(self, model, power, size):
        self._model = model      # protected attribute
        Engine.__init__(self, power)
        Wheels.__init__(self, size)

    # overriding display()
    def display(self):
        print("Car Model:", self._model)
        Engine.display(self)
        Wheels.display(self)


# Example
c = Car("Tesla Model S", "450 HP", "19 inch")
c.display()
