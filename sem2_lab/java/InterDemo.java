import java.util.Scanner;
interface Inter
{
    public double area();
    public double perimeter();
}
class Circle implements Inter
{
    float r;
    Circle(float r)
    {
        this.r=r;
    }
    public double area()
    {
        return 3.14*r*r;
    }
    public double perimeter()
    {
        return 2*3.14*r;
    }
}
class Rectangle implements Inter
{
    int l;
    int b;
    Rectangle(int l,int b)
    {
        this.l=l;
        this.b=b;
    }
    public double area()
    {
        return l*b;
    }
    public double perimeter()
    {
        return 2*(l+b);
    }
}
public class InterDemo 
{
    public static void main(String [] args)
        {
            int cont;
            Scanner sc=new Scanner(System.in);
            do
            {
                System.out.println("\nMenu\n\t1.circle\n\t2.Rectangle\n\t3.Exit");
                System.out.print("Enter Choice: ");
                int ch=sc.nextInt();
                switch (ch) 
                {
                    case 1:
                        System.out.print("\nEnter radius of circle: ");
                        float r=sc.nextFloat();
                        Inter cir=new Circle(r);
                        System.out.print("\nArea of Circle: "+cir.area());
                        System.out.print("\nPerimeter of Circle: "+cir.perimeter());
                        
                        break;
                    case 2:
                        System.out.print("Enter Length of Rectangle: ");
                        int l=sc.nextInt();
                        System.out.print("Enter Breadth of Rectangle: ");
                        int b=sc.nextInt();
                        Inter rect=new Rectangle(l,b);
                        System.out.print("\nArea of Rectangle: "+rect.area());
                        System.out.print("\n\nPerimeter of Rectangle: "+rect.perimeter());
                        break;

                    case 3:
                        System.out.println("Exiting....");
                        break;

                    default:
                        System.out.println("Invalid Input");
                }
                System.out.print("\nPress 1 to continue or 0 to exit: ");
                cont=sc.nextInt();
            }while(cont==1);
        sc.close();
        }
}
