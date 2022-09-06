package part_3.lesson_7.myJava;

public class MyAssert {

    public static void assertEquals(int expect, int actual){
        if(expect != actual){
            throw new AssertionError(expect);
        }
    }

    public static void assertEquals(double expect, double actual) throws AssertionError{
        if(expect != actual){
            throw new AssertionError(expect);
        }
    }

    public static void assertTrue(boolean expect){
        if(!expect){
            throw new AssertionError(false);
        }
    }
}
