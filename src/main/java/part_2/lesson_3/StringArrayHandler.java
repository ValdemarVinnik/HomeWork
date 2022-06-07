package part_2.lesson_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringArrayHandler implements Handler<String> {


    @Override
    public void displayUniqueObjects(String[] array) {

        Set<String> set = new HashSet<>(Arrays.asList(array));

        set.stream().forEach((e) -> System.out.printf("%s ", e));
        System.out.println();
    }

    @Override
    public void countEveryWord(String[] array) {
        Set<String> set = new HashSet<>(Arrays.asList(array));

        for (String wordFromSet : set) {
            int count = 0;
            for (String wordFromArray : array) {
                if (wordFromSet.equals(wordFromArray)) {
                    count++;
                }

            }
            System.out.printf("%s - %d раз(а).\n", wordFromSet, count);
            count = 0;
        }

    }


}
