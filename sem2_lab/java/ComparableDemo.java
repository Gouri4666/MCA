interface Comparable
{
    public double volume();

}
class Cuboid implements Comparable
{
    int l,b,h;
    Cuboid(int l,int b,int h)
    {
        this.l=l;
        this.b=b;
        this.h=h;
    }
    public double volume()
    {
        return l*b*h;
    }
}
class Cylinder implements Comparable
{
    int r,h;
    Cylinder(int r,int h)
    {
        this.r=r;
        this.h=h;
    }
    public double volume()
    {
        return Math.PI*r*r*h;
    }
}
public class ComparableDemo 
{
    public static void main(String[]  args)
    {
        Cuboid cu=new Cuboid(2,5,3);
        Cylinder cy=new Cylinder(5,7);
        System.out.println("Volume of Cylinder: "+cy.volume());
        System.out.println("Volume of Cuboid: "+cu.volume());
        
        if (cu.volume()<cy.volume())
        {
            System.out.println("Cylinder has greater volume");
        }
        else if(cu.volume()>cy.volume())
        {
            System.out.println("Cylinder has greater volume");
        }
        else
        {
            System.out.println("Both have equal volume");
        }
    }   
}
