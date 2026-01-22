# graphics/3D_graphics/sphere.py

import math

def surface_area(radius):
    """Calculate surface area of sphere"""
    return 4 * math.pi * radius ** 2

def volume(radius):
    """Calculate volume of sphere"""
    return 4/3 * math.pi * radius ** 3
