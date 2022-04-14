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

    public static int[] getArray(int length, int initialValue){
        int[] array = new int[length];

        for (int i = 0; i < array.length; i++){
            array[i] = initialValue;
        }
        return array;
    }

    static public void print(String message){
        System.out.println(message);
    }

    static public void printArray(int[] array){
        Arrays.stream(array).forEach((e) -> System.out.print(e+" "));
        System.out.println();
    }

    static public int[][] fillInTheDiagonals(int[][] matrix) throws Exception {

        if (matrix.length != matrix[0].length){
            throw new Exception("Matrix is wrong");
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if( i == j || (i + j) == matrix.length-1 ){
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
//        Создать квадратный двумерный целочисленный массив (количество строк и столбцов
//                одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
//                (можно только одну из диагоналей, если обе сложно). Определить элементы одной из
//        диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0],
//[1][1], [2][2], …, [n][n];

        int[][] emptyMatrix = new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        printMatrix(emptyMatrix);
        printMatrix(fillInTheDiagonals(emptyMatrix));
//5.
//        5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
//        одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
        printArray(getArray(5, 8));

//        6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;


//        7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//                метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
//        массива равны.
//        Примеры:
//        checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
//        checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
//        граница показана символами |||, эти символы в массив не входят и не имеют никакого
//        отношения к ИЛИ.
//        8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть
//        положительным, или отрицательным), при этом метод должен сместить все элементы массива
//        на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
//        вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5,
//                6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете
//        выбирать сами.

    }
}
