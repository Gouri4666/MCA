class ThreadA extends Thread
{
    @Override
    public void run()
    {
        System.out.println("ThreadA started execution");
        for(int i=1;i<=10;i++)
        {
            System.out.println("ThreadA: Square of "+i+" = "+i*i);
            try 
            {
                Thread.sleep(500);    
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
class ThreadB implements Runnable
{
    public void run()
    {
        System.out.println("ThreadB started execution");
        for(int i=1;i<=10;i++)
        {
            System.out.println("Thread B: Cube of "+i+" = "+i*i*i);
            try 
            {
                Thread.sleep(700);    
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadDemo
{
    public static void main(String[] args) 
    {
        ThreadA rA=new ThreadA();
        ThreadB rB=new ThreadB();
        Thread t2=new Thread(rB);
        rA.start();
        t2.start();
        try
        {
            rA.join();
            t2.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Calculation completed!");
    }    
}
