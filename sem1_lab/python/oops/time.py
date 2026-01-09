class Time:
    def __init__(self,h,m,s):
        self.__s=s
        self.__m=m
        self.__h=h
    def __add__(self,other):
        s=self.__s+other.__s
        m=self.__m+other.__m+s//60
        h=self.__h+other.__h+m//60

        s=s%60
        m=m%60
        return Time(h,m,s)
    def __str__(self):
        return f"{self.__h}:{self.__m}:{self.__s}"
t1=Time(5,45,50)
t2=Time(4,30,25)
print(t1)
print(t2)
t3=t1+t2
print(t3)