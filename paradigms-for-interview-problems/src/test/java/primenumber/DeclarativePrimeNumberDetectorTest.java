package primenumber;

import org.junit.Test;
import primenumber.declarative.Classical;
import primenumber.declarative.Dynamic;
import primenumber.declarative.Parallel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeclarativePrimeNumberDetectorTest {

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
    public void parallelIsPrime() {
        PrimeNumberDetector parallel = new Parallel();
        assertTrue( parallel.isPrime(7));
        assertFalse( parallel.isPrime(1) );
        assertFalse( parallel.isPrime(-1) );
        assertTrue( parallel.isPrime(29) );
        assertTrue( parallel.isPrime(307) );
        assertTrue( parallel.isPrime(701) );
    }
}
