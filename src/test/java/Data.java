import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "array delivery")
    public Object[][] getArray(){
        return new Object[][]{{1,2,3,4,5,6},{2,3,4,3,2},{4,2,5,6,7}};
    }
}
