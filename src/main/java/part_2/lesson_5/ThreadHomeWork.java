package part_2.lesson_5;

public class ThreadHomeWork {
    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime =
                System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                    / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: "
                +
                (
                        System.currentTimeMillis() -
                                startTime) + " ms.");
    }

    public static void secondMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime =
                System.currentTimeMillis();
// Создаем два массива для левой и правой части исходного
        float[] firstHalfArr = new float[size / 2];
        float[] secondHalfArr = new float[size / 2];

// Копируем в них значения из большого массива
        for (int i = 0; i < arr.length; i++) {
            if (i <= size / 2)
                firstHalfArr[i] = arr[i];
            else {
                secondHalfArr[i - size/2] = arr[i];            }
        }

// Запускает два потока и параллельно просчитываем каждый малый массив

// Склеиваем малые массивы обратно в один большой
// ...
        System.out.println("Two thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

    public static void main(String[] args) {
        secondMethod();
    }


}
