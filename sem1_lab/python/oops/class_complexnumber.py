class Complex:
    def __init__(self, real, imag):
        self.__real = real
        self.__imag = imag

    def __ge__(self, other):
        # Compare based on magnitude
        mag1 = (self.__real ** 2 + self.__imag ** 2) ** 0.5
        mag2 = (other.__real ** 2 + other.__imag ** 2) ** 0.5
        return mag1 >= mag2

    def display(self):
        print(f"{self.__real} + {self.__imag}i")


# Example usage
c1 = Complex(3, 4)  # magnitude = 5
c2 = Complex(1, 2)  # magnitude ≈ 2.23

c1.display()
c2.display()

if c1 >= c2:
    print("c1 is greater or equal to c2")
else:
    print("c2 is greater than c1")
