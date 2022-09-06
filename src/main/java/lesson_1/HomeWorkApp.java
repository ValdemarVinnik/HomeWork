package lesson_1;

import java.util.Arrays;

public class HomeWorkApp {


    public void printThreeWords() {
        String[] array = new String[]{"Orange", "Banana", "Apple"};
        Arrays.stream(array).forEach((e) -> System.out.println(e));
    }

    public void checkSumSign() {
        int first_var = 2;
        int second_var = -3;
        int sum = first_var + second_var;

        System.out.println(sum > 0 ? "Число положительное" : "Число отрицательное");
    }

    public void printColor() {
        int color = 50;
        String message;

        if (color <= 0) {
            message = "Красный";
        } else if (color > 0 && color <= 100) {
            message = "Желтый";
        } else {
            message = "Зелёный";
        }

        printMessage(message);
    }

    public void compareNumbers() {
        int a = 2;
        int b = 9;
        String message;

        if (a >= b) {
            message = "a >= b";
        } else {
            message = "a < b";
        }
        printMessage(message);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        HomeWorkApp work = new HomeWorkApp();
        work.printThreeWords();
        work.checkSumSign();
        work.printColor();
        work.compareNumbers();

    }

}
