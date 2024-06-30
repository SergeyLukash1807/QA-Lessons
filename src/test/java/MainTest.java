import org.example.Main;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {
    @DataProvider(name = "positiveNumbers")
    public Object[][] providePositiveNumbers() {
        return new Object[][] {
                { 1, 1 },
                { 2, 2 },
                { 3, 6 },
                { 4, 24 },
                { 5, 120 }
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Main.getFactorial(-1);
    }

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(Main.getFactorial(0), 1, "Factorial of 0 should be 1");
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(Main.getFactorial(1), 1, "Factorial of 1 should be 1");
    }


    @Test
    public void testFactorialOfLargeNumber() {
        Assert.assertEquals(Main.getFactorial(10), 3628800, "Factorial of 10 should be 3628800");
    }


    @Test(dataProvider = "positiveNumbers")
    public void testFactorialPositiveNumbers(int num, long expected) {
        Assert.assertEquals(Main.getFactorial(num), expected, "Factorial of " + num + " should be " + expected);
    }
}





