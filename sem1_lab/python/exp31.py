#find area of square,rectangle,and triangle using lambda
square=lambda a:a*a
rectangle=lambda l,b:l*b
triangle=lambda ba,h:0.5*ba*h

a=int(input("Enter side of square:"))
l=int(input("Enter length of rectangle:"))
b=int(input("Enter length of rectangle:"))
h=int(input("Enter height of triangle:"))
ba=int(input("Enter height of triangle:"))
print("Area of square: ",square(a))
print("Area of rectangle: ",rectangle(l,b))
print("Area of triangle: ",triangle(h,ba))
