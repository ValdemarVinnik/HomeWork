package part_2.lesson_2;

/*
1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
 текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой
 именно ячейке лежат неверные данные. 3 В методе main() вызвать полученный метод, обработать возможные
  исключения MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
   при условии что подали на вход корректный массив).
 */
public class ArrayCounter {

    public int countArray(String[][] array) {

        int result = 0;

        if (array.length != 4) {

            throw new MyArraySizeException("Wrong array size...");
        }

        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Wrong array size...");
            }
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    result += convertCell(array[i][j]);
                } catch (MyArrayDataException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return result;
    }

    private int convertCell(String str) throws MyArrayDataException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException();
        }
    }

    public static void main(String[] args) {
        String[][] wrongStringArray = {{"1", "2", "3", "4"},
                {"0", "4", "7", "8"},
                {"o", "7", "I", "6"},
                {"2", "3", "4", "5"}};

        String[][] stringArray = {{"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}};

        String[][] wrongSizeArray = {{"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1"}};

        ArrayCounter counter = new ArrayCounter();
         System.out.println(counter.countArray(stringArray));
        //System.out.println(counter.countArray(wrongSizeArray));
        //System.out.println(counter.countArray(wrongStringArray));
    }


}
