package part_3.lesson_6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtil {
    public static Integer[] cutArrayAfterLastSeparatorNumber(Integer[] array, int separator) {
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
        if (array == null || array.length == 0) {
            throw new RuntimeException();
        }
        return (Arrays.stream(array).allMatch(e -> (e == firstNumberForInspect || e == secondNumberForInspect))&
                Arrays.stream(array).anyMatch(e -> (e == firstNumberForInspect))&
                Arrays.stream(array).anyMatch(e -> (e == secondNumberForInspect)));
    }

    private static <T> void printList(List<T> list) {
        list.stream().forEach(e -> System.out.printf("%d ", e));
        System.out.println();
    }

    private static <T> void printArray(T[] array) {

        Arrays.stream(array).forEach(e -> System.out.printf("%d ", e));
    }
}
