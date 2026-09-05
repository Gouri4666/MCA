class Complex:
    def __init__(self, real, imag):
        self.__real = real
        self.__imag = imag

    def magnitude(self):
        return (self.__real**2 + self.__imag**2) ** 0.5

    # overload >= operator
    def __ge__(self, other):
        return self.magnitude() >= other.magnitude()

    def display(self):
        print(f"{self.__real} + {self.__imag}i")


# Example
c1 = Complex(3, 4)    # magnitude = 5
c2 = Complex(1, 7)    # magnitude = √50 ≈ 7.07

if c1 >= c2:
    print("c1 is greater or equal")
else:
    print("c2 is greater")
