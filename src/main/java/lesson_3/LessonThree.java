package lesson_3;

import java.util.Arrays;

public class LessonThree {

    public static int[] getArrayInversion(int[] array) {

        if (!isBinaryArray(array)) {
            print("Your array is wrong...get it back.");
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

    private static boolean isBinaryArray(int[] array){

        for (int item: array){
            if (item != 0 && item != 1){
                return false;
            }
        }
        return true;
    }

    public static int[] getFullArray(int[] array){

        for (int i = 1; i <= array.length; i++){
            array[i - 1] = i;
        }
        return array;
    }

    public static int [] getMultiplicationSomeMembers(int[] array){

        for (int i = 0; i < array.length; i++){

            if (array[i] < 6){
                array[i] = array[i]*2;
            }
        }
        return array;
    }

    public static int[] getArray(int length, int initialValue) {
        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static int getMin(int[] array) {
        int min = array[0];
        for (int item : array) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }

    public static int getMax(int[] array) {
        int max = array[0];
        for (int item : array) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    public static boolean checkBalance(int[] array) {
        int currentSum = 0;
        int sum = getSumOfMembers(array);
        if (sum % 2 != 0) {
            return false;
        }

        for (int item : array) {
            if ((currentSum += item) == sum / 2) {
                return true;
            }
        }
        return false;
    }

    public static int getSumOfMembers(int[] array) {
        return Arrays.stream(array).sum();
    }

    public static int[] moveContent(int[] array, int step) {
        step = step*(-1);
        if (step < 0) {
            step = array.length + step;
        }
        for (int j = 0; j < step; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i] + array[i + 1];
                array[i + 1] = array[i] - array[i + 1];
                array[i] = array[i] - array[i + 1];
            }
        }
        return array;
    }


    static public void print(String message) {
        System.out.println(message);
    }

    static public void print(int message) {
        System.out.println(message);
    }

    static public void print(boolean message) {
        System.out.println(message);
    }

    static public void printArray(int[] array) {
        Arrays.stream(array).forEach((e) -> System.out.print(e + " "));
        System.out.println();
    }

    static public int[][] fillInTheDiagonals(int[][] matrix) throws Exception {

        if (matrix.length != matrix[0].length) {
            throw new Exception("Matrix is wrong");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j || (i + j) == matrix.length - 1) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    static public void printMatrix(int[][] matrix){

        if (matrix.length != matrix[0].length){
            print("Matrix is wrong");
            return;
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
//1.
        int[] binaryArray = new int[]{1,0,1,1,0,0,1,0,1};
        printArray(getArrayInversion(binaryArray));
//2.
        int[] emptyArray = new int[100];
        printArray(getFullArray(emptyArray));
//3.
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(getMultiplicationSomeMembers(array));
//4.

        int[][] emptyMatrix = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        printMatrix(emptyMatrix);
        printMatrix(fillInTheDiagonals(emptyMatrix));
//5.

        printArray(getArray(5, 8));

//6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        print(getMin(array));
        print(getMax(array));

// 7.

        int[] arrayForCheck = new int[]{1, 1, 1, 2, 1};
        print(checkBalance(arrayForCheck));
// 8.
        int[] arrayForMove = new int[]{1, 2, 3, 4, 5};
        printArray(moveContent(arrayForMove, 1));
    }
}
