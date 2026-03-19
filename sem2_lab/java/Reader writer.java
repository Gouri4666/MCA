//Demonstrate the Reader-Writer problem where the writer writes before the reader reads.

class SharedData {
    private String data;
    private boolean hasData = false;

    public synchronized void write(String value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;
        System.out.println("Writer wrote: " + data);
        hasData = true;
        notify();
    }

    public synchronized void read() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Reader read: " + data);
        hasData = false;
        notify();
    }
}

class Writer extends Thread {
    SharedData data;

    Writer(SharedData data) {
        this.data = data;
    }

    public void run() {
        data.write("Hello from Writer");
    }
}

class Reader extends Thread {
    SharedData data;

    Reader(SharedData data) {
        this.data = data;
    }

    public void run() {
        data.read();
    }
}

public class ReaderWriter {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        Writer writer = new Writer(data);
        Reader reader = new Reader(data);

        writer.start();
        reader.start();
    }
}