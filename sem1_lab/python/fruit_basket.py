class FruitBasket:
    def __init__(self, fruit_name, price_per_kg):
        self.__fruit_name = fruit_name
        self.__price_per_kg = price_per_kg

    def __add__(self, other):
        # Combine unique fruits and keep the lowest price for duplicates
        fruits = {}
        fruits[self.__fruit_name] = self.__price_per_kg
        fruits[other.__fruit_name] = min(fruits.get(other.__fruit_name, other.__price_per_kg), other.__price_per_kg)
        return fruits

    def display(self):
        print(f"{self.__fruit_name} : ₹{self.__price_per_kg}/kg")


# Example usage
f1 = FruitBasket("Apple", 180)
f2 = FruitBasket("Apple", 150)
f3 = FruitBasket("Banana", 60)

result1 = f1 + f2
result2 = f1 + f3

print(result1)
print(result2)
