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

//output
// ThreadA started execution
// ThreadB started execution
// ThreadA: Square of 1 = 1
// Thread B: Cube of 1 = 1
// ThreadA: Square of 2 = 4
// Thread B: Cube of 2 = 8
// ThreadA: Square of 3 = 9
// Thread B: Cube of 3 = 27
// ThreadA: Square of 4 = 16
// ThreadA: Square of 5 = 25
// Thread B: Cube of 4 = 64
// ThreadA: Square of 6 = 36
// Thread B: Cube of 5 = 125
// ThreadA: Square of 7 = 49
// Thread B: Cube of 6 = 216
// ThreadA: Square of 8 = 64
// ThreadA: Square of 9 = 81
// Thread B: Cube of 7 = 343
// ThreadA: Square of 10 = 100
// Thread B: Cube of 8 = 512
// Thread B: Cube of 9 = 729
// Thread B: Cube of 10 = 1000
// Calculation completed
