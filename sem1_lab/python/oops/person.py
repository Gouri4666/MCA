class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def display(self):
        print("Name:", self.name)
        print("Age:", self.age)


class Employee(Person):
    def __init__(self, name, age, empID):
        super().__init__(name, age)
        self.empID = empID

    # overriding
    def display(self):
        super().display()
        print("Employee ID:", self.empID)


class Faculty(Employee):
    def __init__(self, name, age, empID, department):
        super().__init__(name, age, empID)
        self.department = department

    # overriding
    def display(self):
        super().display()
        print("Department:", self.department)


class Researcher:
    def can_do_research(self):
        return "This person can conduct research."


class Professor(Faculty, Researcher):
    def __init__(self, name, age, empID, department):
        super().__init__(name, age, empID, department)

    def display(self):
        super().display()
        print(self.can_do_research())


# Example
p = Professor("Dr. Nair", 45, 1023, "Computer Science")
p.display()
