//Demonstrate the Reader-Writer problem where the writer writes before the reader reads.

class ReaderWriter {

    static int data = 100;
    static boolean written = false;

    // Writer
    static class Writer extends Thread {
        public void run() {
            synchronized (ReaderWriter.class) {
                System.out.println("Writer is writing...");

                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                written = true;
                System.out.println("Writer finished writing");

                ReaderWriter.class.notify(); // wake reader
            }
        }
    }

    // Reader
    static class Reader extends Thread {
        public void run() {
            synchronized (ReaderWriter.class) {
                while (!written) {
                    try {
                        ReaderWriter.class.wait(); // wait for writer
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
        Writer w = new Writer();
        Reader r = new Reader();

        r.start(); // start reader first (it will wait)
        w.start(); // writer writes and notifies
    }
}
