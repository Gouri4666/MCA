import java.util.Scanner;
class Prime
{
    boolean checkPrime(int n)
    {
        if(n<=1)
        return false;
        else
        {
            for(int i=2;i<=Math.sqrt(n);i++)
            {
                if(n%i==0)
                return false;
            }
            return true;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        Prime obj=new Prime();
        if(obj.checkPrime(num))
        System.out.println(num+" is prime");
        else
        System.out.println(num+" is not prime");
    }
}