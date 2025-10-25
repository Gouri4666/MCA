from graphics.triangle import *
from graphics.circle import *

# functions area() and perimeter() now refer to the last imported module's names if same names collide.
# Because both modules define area() and perimeter(), the second import (circle) will overwrite triangle's names.
# To avoid name collision, import with aliases or import modules instead of *
print("Area() now refers to circle.area:", area(2))          # circle.area
print("Perimeter() now refers to circle.perimeter:", perimeter(2))
