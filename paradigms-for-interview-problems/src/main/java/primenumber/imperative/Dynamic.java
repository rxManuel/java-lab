package primenumber.imperative;

import primenumber.PrimeNumberDetector;
import java.util.ArrayList;
import java.util.List;

public class Dynamic implements PrimeNumberDetector {
    // Cache for storing primes
    private static List<Integer> primes = new ArrayList<>();

    public Dynamic() {
        if( primes.isEmpty() ){
            // The first 2 primes in the world... and the Universe
            primes.add(2);
            primes.add(3);
        }
    }

    //fast return / fail fast
    public boolean isPrime(Integer number) {
        if( number <= 1) {
            return false;
        } else if ( primes.contains(number) ) {
            return true;
        } else {
            for(int previous = 4; previous <= Math.sqrt(number); previous++) {
                if(number % previous == 0) {
                   return false;
                }
            }
            primes.add(number);
            return true;
        }

    }

}
