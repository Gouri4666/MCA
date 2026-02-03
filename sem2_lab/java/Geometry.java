class Geometry
{
    int area(int a)
    {
        return a*a;
    }
    int area(int l,int b)
    {
        return l*b;
    }
    double area(double r)
    {
        return 3.14*r*r;
    }
    public static void main(String [] args)
    {
        Geometry g=new Geometry();
        System.out.println("Area of square: "+g.area(5));
        System.out.println("Area of Rectangle: "+g.area(10,4));
        System.out.println("Area of Circle: "+g.area(3.2));
        
    }
}