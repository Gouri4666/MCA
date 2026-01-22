class Currency:
    def __init__(self, amount, unit):
        self.__amount = amount   # private attribute
        self.__unit = unit       # private attribute

    # Overload == operator
    def __eq__(self, other):
        if not isinstance(other, Currency):
            return False
        return self.__amount == other.__amount and self.__unit == other.__unit

    def display(self):
        print(f"Amount: {self.__amount} {self.__unit}")


# Example usage
c1 = Currency(100, "USD")
c2 = Currency(100, "USD")
c3 = Currency(200, "INR")

c1.display()
c2.display()
c3.display()

# Compare using overloaded ==
print("c1 == c2 :", c1 == c2)  # True (same amount and unit)
print("c1 == c3 :", c1 == c3)  # False (different values)
