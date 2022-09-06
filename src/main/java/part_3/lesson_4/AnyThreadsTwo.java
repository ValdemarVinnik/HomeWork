package part_3.lesson_4;

public class AnyThreadsTwo {
    private volatile String currentLetter ;

    private final int REPEAT = 5;

    private Object monitor = new Object();

    private void printA() {
        int count = 0;
        synchronized (monitor) {
            while (count < REPEAT) {
                while (!currentLetter.equals("C")) {
                    try {
                        if (currentLetter == null) break;
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                currentLetter = "A";
                monitor.notifyAll();
                count++;
            }
        }
    }

    private void printB() {
        int count = 0;
        synchronized (monitor) {
            while (count < REPEAT) {
                while (!currentLetter.equals("A")) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                currentLetter = "B";
                monitor.notifyAll();
                count++;
            }
        }
    }

    private void printC() {
        int count = 0;
        synchronized (monitor) {
            while (count < REPEAT) {

                while (!currentLetter.equals("B")) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                currentLetter = "C";
                monitor.notifyAll();
                count++;
            }
        }
    }

    public static void main(String[] args) {
        AnyThreadsTwo threads = new AnyThreadsTwo();
        new Thread(() -> {

                threads.printA();

        }).start();

        new Thread(() -> {

                threads.printB();

        }).start();

        new Thread(() -> {

                threads.printC();

        }).start();
    }
}
