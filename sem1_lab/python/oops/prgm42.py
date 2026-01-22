class Rectangle:
    def __init__(self,l,b):
        self.__l=l
        self.__b=b
    def area(self):
        return self.__l*self.__b
    def __lt__(self,other):
        if self.area()<other.area():
            return True
    def __gt__(self,other):
        if self.area()>other.area():
            return True
r1=Rectangle(5,4)
r2=Rectangle(20,4)
if r1<r2:
    print("l1 is smaller")
elif r1>r2:
    print("l1 is larger")
else:
    print("same")

