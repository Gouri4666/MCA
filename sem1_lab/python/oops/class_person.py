class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def display(self):
        print(f"Name: {self.name}, Age: {self.age}")


class Employee(Person):
    def __init__(self, name, age, empID):
        super().__init__(name, age)
        self.empID = empID

    def display(self):
        super().display()
        print(f"Employee ID: {self.empID}")


class Faculty(Employee):
    def __init__(self, name, age, empID, department):
        super().__init__(name, age, empID)
        self.department = department

    def display(self):
        super().display()
        print(f"Department: {self.department}")


class Researcher:
    def can_do_research(self):
        return "This person can conduct research."


class Professor(Faculty, Researcher):
    def __init__(self, name, age, empID, department):
        Faculty.__init__(self, name, age, empID, department)

    def display(self):
        Faculty.display(self)
        print(self.can_do_research())


# Example usage
prof = Professor("Dr. Gouri Nandana", 35, "EMP123", "Computer Science")
prof.display()
