import org.testng.Assert;
import org.testng.annotations.Test;
import part_3.lesson_6.ArrayUtil;


public class CutArrayAfterLastSeparatorNumber {


    @Test
    public void unitArrayTestWithOneNumbersSeparator4() {
        Integer[] arrayForTest = new Integer[]{1, 2, 3, 4, 5, 6};
        Integer[] expectedArray = new Integer[]{5, 6};
        Integer[] actualArray = ArrayUtil.cutArrayAfterLastSeparatorNumber(arrayForTest, 4);

        Assert.assertEquals(expectedArray,actualArray);
    }

    @Test
    public void unitNullArrayNegativeTest() {
        Integer[] arrayForTest = null;
        Assert.assertThrows(RuntimeException.class, ()-> ArrayUtil.cutArrayAfterLastSeparatorNumber(arrayForTest, 4));

    }

    @Test
    public void unitArrayTestWithoutSeparatorNumber4() {
        Integer[] arrayForTest = new Integer[]{1, 2, 3, 5, 6};
        Assert.assertThrows(RuntimeException.class, ()-> ArrayUtil.cutArrayAfterLastSeparatorNumber(arrayForTest, 4));
    }

    @Test
    public void unitArrayTestWithTwoNumbersSeparator4() {
        Integer[] arrayForTest = new Integer[]{1, 2, 3, 4, 5, 6, 4, 1, 0};
        Integer[] expectedArray = new Integer[]{1, 0};
        Integer[] actualArray = ArrayUtil.cutArrayAfterLastSeparatorNumber(arrayForTest, 4);

        Assert.assertEquals(expectedArray,actualArray);
    }
    @Test
    public void unitArrayTestForSeparatorNumberInEnd() {
        Integer[] arrayForTest = new Integer[]{1, 2, 3, 4, 5, 6, 4, 1, 0, 4};
        Integer[] expectedArray = new Integer[]{};
        Integer[] actualArray = ArrayUtil.cutArrayAfterLastSeparatorNumber(arrayForTest, 4);

        Assert.assertEquals(expectedArray,actualArray);
    }
}
