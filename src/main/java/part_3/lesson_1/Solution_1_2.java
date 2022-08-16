package part_3.lesson_1;

import java.util.Arrays;

public class Solution_1_2 {

    public static  <T> T[] swap(T[] array, int index1, int index2){
        if (array == null) throw new NullPointerException("Sent array is null");
        if (index1 > array.length-1 || index2 > array.length-1 ||
               index1 < 0 || index2 < 0) throw new IndexOutOfBoundsException();

        T box = array[index1];
        array[index1] = array[index2];
        array[index2] = box;

        return array;
    }

    public static <T> void  printArray(T[] array){
        Arrays.stream(array).forEach(e -> System.out.printf("%s ",e));
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] array1 = new Integer[]{1,2,3,4,5};
        String[] array2 = new String[]{"a","b","c","d"};

        printArray(swap(array1,0,3));
        printArray(swap(array2,0,3));

    }
}
