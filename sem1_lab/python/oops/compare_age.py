class Person:
    def __init__(self, name, age):
        self.__name = name
        self.__age = age

    # overload < operator to compare ages
    def __lt__(self, other):
        return self.__age < other.__age

    def display(self):
        print(self.__name, "-", self.__age)


# Example
p1 = Person("Anna", 25)
p2 = Person("John", 30)

if p1 < p2:
    print("Anna is younger than John")
else:
    print("Anna is older than or same age as John")
