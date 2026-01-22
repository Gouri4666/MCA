class Rectangle:
    def __init__(self,length,breadth):
        self.length=length
        self.breadth=breadth
    def area(self):
        return self.length*self.breadth
    def peri(self):
        return 2*(self.length+self.breadth)
    def compare(self,other):
        if self.area()==other.area():
            return "same area"
        else:
            return "not same"
l1=int(input("Enter length1: "))
b1=int(input("Enter breadth1: "))

l2=int(input("Enter length2: "))
b2=int(input("Enter breadth2: "))

r1=Rectangle(l1,b1)
r2=Rectangle(l2,b2)

print(r1.compare(r2))



