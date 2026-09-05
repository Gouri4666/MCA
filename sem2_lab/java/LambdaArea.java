
interface Dim
{
    double area(double x);
}
public class LambdaArea
{
    public static void main(String [] args)
    {
        Dim Square=side->side*side;
        Dim Cube=side->6*side*side;
        Dim Circle=radius->Math.PI*radius*radius;
        Dim Sphere=radius->4*Math.PI*radius*radius;
        System.out.println("Area of square: "+Square.area(5));
        System.out.println("Area of Cube: "+Cube.area(4));
        System.out.println("Area of Circle: "+Circle.area(3));
        System.out.println("Area of Sphere: "+Sphere.area(6));
    }
}
