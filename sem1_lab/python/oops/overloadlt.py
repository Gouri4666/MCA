class Rectangle:
    def __init__(self,l,b):
        self.l=l
        self.b=b
    def area(self):
        return self.l*self.b
    def __lt__(self,other):
        return self.area()<other.area()
r1=Rectangle(4,4)
r2=Rectangle(8,2)
print(r1.area())
print(r2.area())

if r1<r2:
    print("Rectangle1 is lesser")
else:
        print("Rectangle2 is lesser")