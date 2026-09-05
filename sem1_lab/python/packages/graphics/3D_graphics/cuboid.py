# graphics/3D_graphics/cuboid.py

def surface_area(length, breadth, height):
    """Calculate surface area of cuboid"""
    return 2 * (length*breadth + breadth*height + height*length)

def volume(length, breadth, height):
    """Calculate volume of cuboid"""
    return length * breadth * height
