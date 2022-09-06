package part_3.lesson_4;

public class AnyThreads {
    private final int REPEAT = 5;
    private volatile String currentLetter = "C";
    private volatile String lastLetter = "B";

    private final Object monitor = new Object();

    private void printLetter(String letter) {

        synchronized (monitor) {

            while ((lastLetter.equals(letter) || currentLetter.equals(letter))) {
                try {
                    monitor.wait();
                } catch (InterruptedException | IllegalMonitorStateException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(letter);
            lastLetter = currentLetter;
            currentLetter = letter;
            monitor.notifyAll();
        }
    }

    public void chainOfThreads() {
        new Thread(() -> {
            for (int i = 1; i <= REPEAT; i++) {
                printLetter("A");
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= REPEAT; i++) {
                printLetter("B");
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= REPEAT; i++) {
                printLetter("C");
            }

        }).start();

    }

    public static void main(String[] args) {
        new AnyThreads().chainOfThreads();
    }
}
