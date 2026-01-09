class Person:
    def __init__(self, name, age):
        self.__name = name
        self.__age = age

    # Overload < operator
    def __lt__(self, other):
        return self.__age < other.__age

    def display(self):
        print(f"Name: {self.__name}, Age: {self.__age}")


# Example usage
p1 = Person("Gouri", 22)
p2 = Person("Nandana", 25)

p1.display()
p2.display()

if p1 < p2:
    print(f"{p2._Person__name} is older than {p1._Person__name}")
else:
    print(f"{p1._Person__name} is older than {p2._Person__name}")
