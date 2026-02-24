import java.util.Scanner;
class MultiTable
{
    void multi(int n)
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println(n+" x "+i+" = "+(n*i));
        }
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        MultiTable m=new MultiTable();
        System.out.print("Enter  n: ");
        int n=sc.nextInt();
        m.multi(n);
        sc.close();
    }
}
