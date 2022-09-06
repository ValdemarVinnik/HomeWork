package part_2.lesson_5;

import java.util.ArrayList;

public class ThreadHomeWork {
    public static void firstMethod() {

        int size = 10_000_000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

    public static void secondMethod() throws InterruptedException {

        int size = 10_000_000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();
// Создаем два массива для левой и правой части исходного

        float[] firstHalfArr = new float[size / 2];
        float[] secondHalfArr = new float[size / 2];

// Копируем в них значения из большого массива

        for (int i = 0; i < arr.length; i++) {
            if (i < size / 2)
                firstHalfArr[i] = arr[i];
            else {
                secondHalfArr[i - size / 2] = arr[i];
            }
        }
// Запускает два потока и параллельно просчитываем каждый малый массив

        MyThreadArrayExecutor firstExecutor = new MyThreadArrayExecutor();
        MyThreadArrayExecutor secondExecutor = new MyThreadArrayExecutor();

        firstExecutor.setArray(firstHalfArr);
        secondExecutor.setArray(secondHalfArr);

        firstExecutor.start();
        secondExecutor.start();

        firstExecutor.join();
        secondExecutor.join();

// Склеиваем малые массивы обратно в один большой
// ...
        float[] newArray = new float[size];
        for (int i = 0; i < size; i++) {
            if (i < size / 2) {
                newArray[i] = firstHalfArr[i];
            } else {
                newArray[i] = secondHalfArr[i - size / 2];
            }
        }

        arr = newArray;

        System.out.println("Two thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

    public static void thirdMethod() throws InterruptedException {

        int size = 10_000_000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();
// Создаем 4 массива

        float[] firstArr = new float[size / 4];
        float[] secondArr = new float[size / 4];
        float[] thirdArr = new float[size / 4];
        float[] fourthArr = new float[size / 4];

// Копируем в них значения из большого массива

        for (int i = 0; i < arr.length; i++) {
            if (i < size / 4)

                firstArr[i] = arr[i];

            else if (i < size / 2) {

                secondArr[i - size / 4] = arr[i];

            } else if (i < (size / 4) + (size / 2)) {

                thirdArr[i - size / 2] = arr[i];
            } else {
                fourthArr[i - (size / 4) - (size / 2)] = arr[i];
            }
        }
// Запускает два потока и параллельно просчитываем каждый малый массив

        MyThreadArrayExecutor firstExecutor = new MyThreadArrayExecutor();
        MyThreadArrayExecutor secondExecutor = new MyThreadArrayExecutor();
        MyThreadArrayExecutor thirdExecutor = new MyThreadArrayExecutor();
        MyThreadArrayExecutor fourthExecutor = new MyThreadArrayExecutor();

        firstExecutor.setArray(firstArr);
        secondExecutor.setArray(secondArr);
        thirdExecutor.setArray(thirdArr);
        fourthExecutor.setArray(fourthArr);

        firstExecutor.start();
        secondExecutor.start();
        thirdExecutor.start();
        fourthExecutor.start();

        firstExecutor.join();
        secondExecutor.join();
        thirdExecutor.join();
        fourthExecutor.join();

// Склеиваем малые массивы обратно в один большой
// ...
        float[] newArray = new float[size];
        for (int i = 0; i < arr.length; i++) {
            if (i < size / 4)

                newArray[i] = firstArr[i];

            else if (i < size / 2) {

                newArray[i] = secondArr[i - size / 4];

            } else if (i < (size / 4) + (size / 2)) {

                newArray[i] = thirdArr[i - size / 2];
            } else {
                newArray[i] = fourthArr[i - (size / 4) - (size / 2)];
            }
        }

        arr = newArray;

        System.out.println("Four thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");

    }

    private static void printArray(float[] array){
        for (float each : array){
            System.out.println(each);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
        thirdMethod();
    }


}

class MyThreadArrayExecutor extends Thread {
    private float[] array;

    public void setArray(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                    / 5) * Math.cos(0.4f + i / 2));
        }
    }
}


