package part_3.lesson_7.myTests;

import part_3.lesson_7.annotations.AfterSuit;
import part_3.lesson_7.annotations.BeforeSuit;
import part_3.lesson_7.annotations.Test;
import part_3.lesson_7.myJava.Calculator;
import part_3.lesson_7.myJava.MyAssert;


public class CalculatorTest {

    @BeforeSuit
    public void setup() {
        System.out.println("setup()");

    }

    @Test(value = 1)
    public void testSum() {
        System.out.println("testSum()");
        int actual = new Calculator().sum(2, 2);
        int expect = 4;
        MyAssert.assertEquals(actual, expect);
    }

    @Test(value = 3)
    public void testMultiply() {
        System.out.println("testMultiply()");
        int actual = new Calculator().multiply(2, 3);
        int expect = 6;
        MyAssert.assertEquals(actual, expect);
    }

    @Test(value = 2)
    public void testDivide() {
        System.out.println("testDivide()");
        double actual = new Calculator().divide(6, 2);
        double expect = 3;
        MyAssert.assertEquals(actual, expect);
    }

    @AfterSuit
    public void close(){
        System.out.println("close()");

    }
}
