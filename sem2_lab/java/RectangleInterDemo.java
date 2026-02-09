interface Measurable
{
    double calculateVolume();
}
interface Printable
{
    void displayVolume();
}
class Rectangle 
{
    int l;
    int w;
    Rectangle(int l,int w)
    {
        this.l=l;
        this.w=w;
    }

}
class Cuboid extends Rectangle implements Measurable,Printable
{
    int h;
    Cuboid(int l,int w,int h)
    {
        super(l,w);
        this.h=h;
    }
    public double calculateVolume()
    {
        return l*w*h;
    }
    public void displayVolume()
    {
        System.out.println("Length: "+l);
        System.out.println("Width: "+w);
        System.out.println("Height: "+h);
        System.out.println("Volume: "+calculateVolume());
        
    }
}
public class RectangleInterDemo
{
    public static void main(String[] args)
    {
        Cuboid c=new Cuboid(2,5,3);
        c.displayVolume();
    }
}


// output
// Length: 2
// Width: 5
// Height: 3
// Volume: 30.0
