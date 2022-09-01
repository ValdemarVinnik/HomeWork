package part_3.lesson_6;

import org.w3c.dom.ls.LSOutput;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtil {
    public static Integer[] cutArrayAfterLast4(Integer[] array, int separator) {
        if (array == null || !Arrays.stream(array).anyMatch(e -> e == separator)) {
            throw new RuntimeException();
        }

        List<Integer> tempList = Arrays.asList(array);
        Collections.reverse(tempList);

        List<Integer> finalList = tempList.stream().takeWhile(e -> e != separator).collect(Collectors.toList());
        Collections.reverse(finalList);

        Integer[] newArray = new Integer[finalList.size()];
        finalList.toArray(newArray);
        return newArray;


    }

    public static boolean inspectArray(int firstNumberForInspect, int secondNumberForInspect, Integer...array){
        return Arrays.stream(array).allMatch(e -> (e == firstNumberForInspect || e == secondNumberForInspect));
    }

    private static Integer[] reversArray(Integer[] array) {
        Integer[] newArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[array.length - i] = array[i];
        }
        return newArray;
    }

    private static <T> void printList(List<T> list) {
        list.stream().forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }

    private static<T> void printArray(T[] array) {
        Arrays.stream(array).forEach(e -> System.out.printf("%d ", e));
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        //printArray(array);
        printArray(cutArrayAfterLast4(array, 4));

        System.out.println(inspectArray(1,4,1,1,1,4,1,4,1,4));

    }
}
