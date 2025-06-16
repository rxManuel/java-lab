package perfectNumber;

import org.junit.Test;
import perfectnumber.PerfectNumberDetector;
import perfectnumber.imperative.Classical;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImperativePerfectNumberDetectorTest {

    @Test
    public void classicalIsPerfectNumber() {
        PerfectNumberDetector classical = new Classical();
        assertTrue(classical.isPerfectNumber(6));
        assertTrue(classical.isPerfectNumber(28));
        assertTrue(classical.isPerfectNumber(496));
        assertTrue(classical.isPerfectNumber(8128));
        assertFalse(classical.isPerfectNumber(2));
        assertFalse(classical.isPerfectNumber(12));
        assertFalse(classical.isPerfectNumber(27));
        assertFalse(classical.isPerfectNumber(1));
        assertTrue(classical.isPerfectNumber(33550336));
        assertFalse(classical.isPerfectNumber(10000));
    }
}
