class Flower:
    def __init__(self, name):
        self.name = name

name = input("Enter flower name: ")
f = Flower(name)

color = input("Enter petal color (press enter to skip): ")

if color:
    f.petalColor = color
    print(f"{f.petalColor} {f.name}")
else:
    print("Unknown Flower")
