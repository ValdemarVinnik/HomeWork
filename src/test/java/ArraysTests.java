import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import part_3.lesson_6.ArrayUtil;

public class ArraysTests {


    @Test
    public void unitArrayTest() {
        Integer[] arrayForTest = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] expectedArray = new Integer[]{5, 6};
        Integer[] actualArray = ArrayUtil.cutArrayAfterLast4(arrayForTest, 4);

        Assert.assertEquals(expectedArray,actualArray);
    }

}
