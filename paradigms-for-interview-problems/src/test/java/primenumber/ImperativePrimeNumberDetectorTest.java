package primenumber;

import org.junit.Test;
import primenumber.imperative.Classical;
import primenumber.imperative.Concurrent;
import primenumber.imperative.Dynamic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImperativePrimeNumberDetectorTest {

    @Test
    public void classicalIsPrime() {
        PrimeNumberDetector classic = new Classical();
        assertTrue( classic.isPrime(7) );
        assertFalse( classic.isPrime(1) );
        assertFalse( classic.isPrime(-1) );
        assertTrue( classic.isPrime(29) );
        assertTrue( classic.isPrime(307) );
        assertTrue( classic.isPrime(701) );
    }

    @Test
    public void dynamicIsPrime() {
        PrimeNumberDetector dynamic = new Dynamic();
        assertTrue( dynamic.isPrime(7) );
        assertFalse( dynamic.isPrime(1) );
        assertFalse( dynamic.isPrime(-1) );
        assertTrue( dynamic.isPrime(29) );
        assertTrue( dynamic.isPrime(307) );
        assertTrue( dynamic.isPrime(701) );
    }

    @Test
    public void concurrentIsPrime() {
        PrimeNumberDetector concurrent = new Concurrent();
        assertTrue( concurrent.isPrime(7) );
        assertFalse( concurrent.isPrime(1) );
        assertFalse( concurrent.isPrime(-1) );
        assertTrue( concurrent.isPrime(29) );
        assertTrue( concurrent.isPrime(307) );
        assertFalse( concurrent.isPrime(310) );
        assertTrue( concurrent.isPrime(701) );
        assertFalse( concurrent.isPrime(752) );
        assertTrue( concurrent.isPrime(1511) );
    }
}
