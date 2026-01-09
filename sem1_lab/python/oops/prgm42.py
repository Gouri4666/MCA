class Rectangle:
    def __init__(self,l,w):
        self.__l=l
        self.__w=w
    def area(self):
        return self.__l*self.__w
    def __lt__(self,other):
        return self.area()<other.area()
r1=Rectangle(8,4)
r2=Rectangle(4,4)
if r1<r2:
    print("R1 less than R2")
else:
    print("R2 less than R1")
    
