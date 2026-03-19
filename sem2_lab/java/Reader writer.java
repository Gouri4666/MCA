//Demonstrate the Reader-Writer problem where the writer writes before the reader reads.
class ReaderWriter {

    static int data = 100;
    static boolean written = false;

    static final Object lock = new Object(); // simple lock object

    // Writer Thread
    static class Writer extends Thread {
        public void run() {
            synchronized (lock) {
                System.out.println("Writer is writing...");

                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                written = true;
                System.out.println("Writer finished writing");

                lock.notify(); 
            }
        }
    }

    // Reader Thread
    static class Reader extends Thread {
        public void run() {
            synchronized (lock) {
                while (!written) {
                    try {
                        lock.wait(); // wait for writer
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Reader is reading...");
                System.out.println("Data read: " + data);
            }
        }
    }

    public static void main(String[] args) {
        Reader r = new Reader();
        Writer w = new Writer();

        r.start(); // reader waits
        w.start(); // writer writes first
    }
}

//--------output-------------
// Writer is writing...
// Writer finished writing
// Reader is reading...
// Data read: 100
