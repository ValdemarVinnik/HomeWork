package part_2.lesson_3;

import java.util.*;

public class StringArrayHandler implements Handler<String> {


    @Override
    public void displayUniqueObjects(String[] array) {

        Set<String> set = new HashSet<>(Arrays.asList(array));

        set.stream().forEach((e) -> System.out.printf("%s ", e));
        System.out.println();
    }
/**
 * Метод использовался для сравнения производительности....
 */
//    @Override
//    public void countEveryWord(String[] array) {
//        long start = new Date().getTime();
//        Set<String> set = new HashSet<>(Arrays.asList(array));
//
//        for (String wordFromSet : set) {
//            int count = 0;
//            for (String wordFromArray : array) {
//                if (wordFromSet.equals(wordFromArray)) {
//                    count++;
//                }
//
//            }
//            //System.out.printf("%s - %d раз(а).\n", wordFromSet, count);
//            count = 0;
//        }
//        long finish = new Date().getTime();
//        System.out.println("time of completion :" + (finish - start));
//    }

    /**
     * Закоментированные строки метода использовались для тзмерения производительности.
     * Если измерять с выводом в консоль - то всё не однозначно.
     *
     * @param array
     */
    @Override
    public void countEveryWord(String[] array) {
        // long start = new Date().getTime();

        Map<String, Integer> map = new HashMap<>(array.length);

        for (String word : array) {
            Integer count = map.put(word, 1);
            if (count != null) {
                map.put(word, count + 1);
            }
        }
        // long finish = new Date().getTime();
        // System.out.println("time of completion :" + (finish - start));

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.printf("%s - %d раз(а).\n", pair.getKey(), pair.getValue());
        }
    }
}
