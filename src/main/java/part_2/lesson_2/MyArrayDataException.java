package part_2.lesson_2;

public class MyArrayDataException extends NumberFormatException {
    private static final String EXCEPTION_MESSAGE = "Wrong cell is row - %d column - %d .";

    public MyArrayDataException() {
    }

    public MyArrayDataException(int param1, int param2) {
        super(String.format(EXCEPTION_MESSAGE, param1 + 1, param2 + 1));
    }
}
