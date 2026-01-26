import java.util.Scanner;
class Fibonacci
{
    static int fibo(int n)
    {
        if(n==0)
        return 0;
        else if(n==1)
        return 1;
        else
        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter position: ");
        int num=sc.nextInt();
        int result=fibo(num);
        System.out.println("Fibonnacci Number: "+result);
    }
}