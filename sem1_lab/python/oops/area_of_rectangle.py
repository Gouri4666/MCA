class Rectangle:
    def __init__(self,l,b):
        self.l=l
        self.b=b
    def area(self):
        return self.l*self.b
    def peri(self):
        return 2*(self.l+self.b)
    def comparearea(self,other):
        if self.area()!=other.area():
            return "Area not equal"
        else:
            return "Area equal"
    def compareperi(self,other):
        if self.peri()!=other.peri():
            return "Perimeter not equal"
        else:
            return "Perimeter equal"
    
r1=Rectangle(6,4)
r2=Rectangle(5,5)
print(f"Reactangle 1:{r1.l},{r1.b}")
print(f"Reactangle 1:{r2.l},{r2.b}")

print(f"Areas= {r1.area()},{r2.area()}")
print(f"Perimeters= {r1.peri()},{r2.peri()}")
print(r1.comparearea(r2))
print(r1.compareperi(r2))


        