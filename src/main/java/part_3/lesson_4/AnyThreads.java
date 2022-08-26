package part_3.lesson_4;

public class AnyThreads {
    private volatile String pattern = "ABC";
    private volatile String currentLetter = "C";
    private volatile String lastLetter = "B";

    private final Object monitor = new Object();

    private void printLetter(Boolean printIsPossible, String letter) {

        synchronized (monitor) {

            while ((!lastLetter.equals(letter )||currentLetter.equals(letter))) {
                try {
                    monitor.wait();

                } catch (InterruptedException | IllegalMonitorStateException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(letter);
            lastLetter = currentLetter;
            currentLetter = letter;
            monitor.notify();
        }
    }

    public void chainOfThreads() {
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                printLetter((currentLetter.equals("C")), "A");
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                printLetter((currentLetter.equals("A")), "B");
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                printLetter((currentLetter.equals("B")), "C");
            }

        }).start();

    }

    public static void main(String[] args) {
        new AnyThreads().chainOfThreads();
    }
}
