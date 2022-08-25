package part_3.lesson_4;

public class AnyThreads {
    private synchronized void printLetter(String letter) {
        System.out.print(letter);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    public void chainOfThreads() {
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                printLetter("A");
            }

        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                printLetter("B");
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                printLetter("C");
            }

        }).start();

    }

    public static void main(String[] args) {
        new AnyThreads().chainOfThreads();
    }
}
