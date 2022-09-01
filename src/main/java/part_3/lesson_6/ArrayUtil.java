package part_3.lesson_6;

import org.w3c.dom.ls.LSOutput;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUtil {
    public static int[] cutArrayAfterLast4(int[] array){
        // if array = null;


        //boolean isPosible = Arrays.stream(array).anyMatch(e -> e == 4);
        //Arrays.stream(reversArray(array)).takeWhile(e -> e != 4).collect()
        return  array;

    }
    private static int[]  reversArray(int[] array){
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[array.length-i] = array[i];
        }
        return newArray;
    }
    public static void printArray(int[] array){
        Arrays.stream(array).forEach(e -> System.out.printf("%d ",e));
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6};
        printArray(array);
        printArray(cutArrayAfterLast4(array));

    }
}
