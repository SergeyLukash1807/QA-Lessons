import org.example.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @ParameterizedTest
    @CsvSource({"0,1", "1,1", "7,78"})
    void testFactorial(int num, int expected) {
        assertNotNull(Main.getFactorial(num));
        assertEquals(Main.getFactorial(num), expected);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, -4 })
    void testFactorialNonNegative(int num) {
        assertFalse(Main.getFactorial(num) < 0, "Factorial result should not be negative for input: " + num);
    }
    @Test
    void testFactorialBoundaryValues() {
        // Граница для целого числа
        int boundaryValue = 20; // 20! = 2,432,902,008,176,640,000
        assertEquals(2432902008176640000L, Main.getFactorial(boundaryValue), "Factorial of " + boundaryValue + " should be 2432902008176640000");
    }

    @Test
    void testFactorialRepeatedCalls() {
        int num = 5;
        long expected = 120;
        assertEquals(expected, Main.getFactorial(num), "Factorial of " + num + " should be " + expected);
        assertEquals(expected, Main.getFactorial(num), "Factorial of " + num + " should be " + expected + "on repeated call");
    }
}