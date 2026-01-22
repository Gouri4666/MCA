#find area of square,rectangle,and triangle using lambda
area=lambda shape,x,y=0:x**2 if shape=="square" else (x*y if shape=="rectangle" else 0.5*x*y)
print(area("square",5))
print(area("rectangle",5,4))
print(area("traingle",8,5))

