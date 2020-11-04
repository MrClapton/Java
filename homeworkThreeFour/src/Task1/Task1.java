package Task1;

public class Task1 {
    private final Object monitor = new Object();
    private final int loopCount = 5;
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Task1 w = new Task1();

        Thread t1 = new Thread(w::printA);
        Thread t2 = new Thread(w::printB);
        Thread t3 = new Thread(w::printC);

        t1.start();
        t2.start();
        t3.start();

    }

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < loopCount; i++) {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < loopCount; i++) {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < loopCount; i++) {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

