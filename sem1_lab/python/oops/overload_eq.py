class Currency:
    def __init__(self, amount, unit):
        self.amount = amount
        self.unit = unit

    # overload == operator
    def __eq__(self, other):
        return self.amount == other.amount and self.unit == other.unit


# Example
c1 = Currency(100, "USD")
c2 = Currency(100, "USD")
c3 = Currency(200, "INR")

print(c1 == c2)   # True
print(c1 == c3)   # False
