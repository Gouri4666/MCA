class Rectangle:
    def __init__(self,l,b):
        self.l=l
        self.b=b
    def area(self):
        return self.l*self.b
    def peri(self):
        return 2*(self.l+self.b)
    def carea(self,other):
        if self.area()==other.area():
            print("Same area")
        else:
            print("Different area")
    def cperi(self,other):
        if self.peri()==other.peri():
            print("Same peri")
        else:
            print("Different peri")
r1=Rectangle(4,4)
r2=Rectangle(8,2)
r1.carea(r2)
r1.cperi(r2)

