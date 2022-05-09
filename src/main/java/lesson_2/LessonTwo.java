package lesson_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LessonTwo {

    public boolean checkSumInterval(int first, int second) {
        int sum = first + second;
        return (sum >= 10 && sum <= 20);
    }

    public void determineTheNumber(int number) {
        String message = String.format("полученное число -%s", (IsNegative(number)) ? "отрицательное" : "положительное");
        printMessage(message);
    }

    public boolean IsNegative(int number) {
        return number < 0;
    }

    public void repeatLines(String str, int amount) {
        printMessage(str);
        if (amount > 1) {
            repeatLines(str, --amount);
        }
    }

    public boolean IsLeapYearNow(){

        SimpleDateFormat sdt = new SimpleDateFormat("YYYY");
        int year = Integer.parseInt(sdt.format(new Date()));

        return ((year % 4 == 0 && year % 100 !=0) || year % 400 == 0);

    }

    private void printMessage(String message) {
        System.out.println(message);

    }

    private void printMessage(int message) {
        System.out.println(message);

    }

    private void printMessage(boolean message) {
        System.out.println(message);

    }

    public static void main(String[] args) {
        LessonTwo lesson = new LessonTwo();

        lesson.printMessage(lesson.checkSumInterval(9, 11));

        lesson.repeatLines("Боже царя храни", 3);

        lesson.determineTheNumber(-1);

        lesson.printMessage(lesson.IsNegative(1));

        lesson.printMessage(lesson.IsLeapYearNow());
    }
}
