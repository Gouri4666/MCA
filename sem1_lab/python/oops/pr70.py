# Base Class
class Rectangle:
    def __init__(self, length, breadth):
        self.length = length
        self.breadth = breadth


# Derived Class
class Cuboid(Rectangle):
    def __init__(self, length, breadth, height):
        super().__init__(length, breadth)
        self.height = height

    # Calculate volume
    def volume(self):
        return self.length * self.breadth * self.height

    # Operator overloading for <
    def __lt__(self, other):
        return self.volume() < other.volume()

    # Display details
    def display(self):
        print("Length:", self.length)
        print("Breadth:", self.breadth)
        print("Height:", self.height)
        print("Volume:", self.volume())
        print()


# ----- Main Program -----
print("Enter details of Cuboid 1")
l1 = int(input("Length: "))
b1 = int(input("Breadth: "))
h1 = int(input("Height: "))
c1 = Cuboid(l1, b1, h1)

print("\nEnter details of Cuboid 2")
l2 = int(input("Length: "))
b2 = int(input("Breadth: "))
h2 = int(input("Height: "))
c2 = Cuboid(l2, b2, h2)

print("\nCuboid 1 Details:")
c1.display()

print("Cuboid 2 Details:")
c2.display()

# Comparison using < operator
if c1 < c2:
    print("Cuboid 2 has greater volume")
else:
    print("Cuboid 1 has greater volume")
