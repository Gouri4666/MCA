class Rectangle:
    def __init__(self, length, width):
        self.length = length
        self.width = width

    def area(self):
        return self.length * self.width

    def __lt__(self, other):
        return self.area() < other.area()

    def __gt__(self, other):
        return self.area() > other.area()


# Example
r1 = Rectangle(5, 4)
r2 = Rectangle(6, 3)

print("Area of Rectangle 1:", r1.area())
print("Area of Rectangle 2:", r2.area())

if r1 > r2:
    print("Rectangle 1 is larger")
elif r1 < r2:
    print("Rectangle 2 is larger")
else:
    print("Both rectangles are equal")
