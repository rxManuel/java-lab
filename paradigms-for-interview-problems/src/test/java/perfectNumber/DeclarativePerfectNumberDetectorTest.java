package perfectNumber;

import org.junit.Test;
import perfectnumber.PerfectNumberDetector;
import perfectnumber.declarative.Classical;
import perfectnumber.declarative.Dynamic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeclarativePerfectNumberDetectorTest {
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

    @Test
    public void dynamicIsPerfectNumber() {
        PerfectNumberDetector dynamic = new Dynamic();
        assertTrue(dynamic.isPerfectNumber(6));
        assertTrue(dynamic.isPerfectNumber(28));
        assertTrue(dynamic.isPerfectNumber(496));
        assertTrue(dynamic.isPerfectNumber(8128));
        assertFalse(dynamic.isPerfectNumber(2));
        assertFalse(dynamic.isPerfectNumber(12));
        assertFalse(dynamic.isPerfectNumber(27));
        assertFalse(dynamic.isPerfectNumber(1));
        assertTrue(dynamic.isPerfectNumber(33550336));
        assertFalse(dynamic.isPerfectNumber(10000));
    }
}
