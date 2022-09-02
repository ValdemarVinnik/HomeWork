import org.testng.Assert;
import org.testng.annotations.Test;
import part_3.lesson_6.ArrayUtil;

public class InspectArrayTest {

    @Test
    public void unitPositiveInspectArrayTest() {
        Assert.assertTrue(ArrayUtil.inspectArray(1, 4, 1, 1, 4, 4, 1, 4, 1));
    }

    @Test
    public void unitNegativeInspectArrayTest() {
        Assert.assertTrue(!ArrayUtil.inspectArray(1, 4, 1, 3, 4, 4, 1, 4, 1));
    }

    @Test
    public void unitNegativeInspectArrayTestExpectTrowsWithEmptyArray() {
        Assert.assertThrows(RuntimeException.class, () -> ArrayUtil.inspectArray(1, 4));

    }

    @Test
    public void unitNegativeInspectArrayTestExpectTrowsWithNullArray() {
        Integer[] nullArray = null;
        Assert.assertThrows(RuntimeException.class, () -> ArrayUtil.inspectArray(1, 4, nullArray));

    }
}
