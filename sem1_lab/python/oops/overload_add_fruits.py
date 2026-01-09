class FruitBasket:
    def __init__(self, fruit_name, price_per_kg):
        # store fruits in a dictionary
        self.fruits = {fruit_name: price_per_kg}

    # overload + operator
    def __add__(self, other):
        new_basket = FruitBasket("", 0)  
        new_basket.fruits = {}

        # Add fruits from first basket
        for fruit, price in self.fruits.items():
            new_basket.fruits[fruit] = price

        # Add fruits from second basket with least price
        for fruit, price in other.fruits.items():
            if fruit in new_basket.fruits:
                new_basket.fruits[fruit] = min(new_basket.fruits[fruit], price)
            else:
                new_basket.fruits[fruit] = price

        return new_basket

    def display(self):
        for fruit, price in self.fruits.items():
            print(f"{fruit} : ₹{price}")


# Example
b1 = FruitBasket("Apple", 100)
b1.fruits["Mango"] = 150

b2 = FruitBasket("Apple", 90)
b2.fruits["Orange"] = 120

b3 = b1 + b2
b3.display()
