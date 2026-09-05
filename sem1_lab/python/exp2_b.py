#create a list of color from comma sepaerated list of color names , print alternative colors
colors=input("Enter list of colors sepersted by comma: ").split(",")
res=colors[::2]
print(res)