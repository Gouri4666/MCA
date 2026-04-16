//Demonstrate the Reader-Writer problem where the writer writes before the reader reads.
class Test
{
    static int data=100;
    static boolean written=false;
    static final Object lock=new Object();
    static class Writer extends Thread
    {
        public void run()
        {
            synchronized (lock)
            {
                System.out.println("writer is writing...");
                data=150;
                try
                {
                    Thread.sleep(1000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                written=true;
                lock.notify();
                System.out.println("Writer finished writing");
                System.out.println("New data: "+data);
            }
        }
    }
    static class Reader extends Thread
    {
        public void run()
        {
            synchronized(lock)
            {
                while(!written)
                {
                    try
                    {
                        lock.wait();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println("Reader is reading...");
                try
                {
                Thread.sleep(1000);
                }
                catch(Exception e)
                {
                    System.err.println();
                }
                System.out.println("Data: "+data);
            }
        }
    }
    public static void main(String[] args) {
        Writer w1=new Writer();
        Reader r1=new Reader();
        System.out.println("Initail data: "+data);
        w1.start();;
        r1.start();
    }
}
//--------output-------------
// Initail data: 100
// writer is writing...
// Writer finished writing
// New data: 150
// Reader is reading...
// Data: 150
