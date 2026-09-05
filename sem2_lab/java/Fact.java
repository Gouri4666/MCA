import java.util.Scanner;
class Fact
{
    static int factorial(int n)
    {
        if(n==0)
        return 1;
        else
        {
            return n*factorial(n-1);
        }
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        System.out.print("Factorial: "+factorial(n));
    }
}
