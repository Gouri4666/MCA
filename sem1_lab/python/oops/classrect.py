class Rectangle:
    def __init__(self, length, breadth):
        self.length = length
        self.breadth = breadth

    def area(self):
        return self.length * self.breadth

    def perimeter(self):
        return 2 * (self.length + self.breadth)

    def compare_area(self, other):
        if self.area() != other.area():
            return "Area are different"
        else:
            return "Both rectangles have equal area"


# Example
r1 = Rectangle(5, 4)
r2 = Rectangle(6, 3)

print("Area of Rectangle 1:", r1.area())
print("Perimeter of Rectangle 1:", r1.perimeter())
print("Area of Rectangle 2:", r2.area())
print(r1.compare_area(r2))
