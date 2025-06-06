package primenumber.imperative;

import primenumber.PrimeNumberDetector;

public class Classical implements PrimeNumberDetector {
    //Single return
    public boolean isPrime(Integer number) {
        boolean isPrime = true; //positive case assumption to fast failing
        // By definition 1 and number less than 1 are not primes
        if(number <= 1) {
            isPrime = false;
        } else {
            // Although iterating until sqrt(number) is more efficient,
            // we iterate until number / 2 to illustrate the concept:
            // no number greater than n/2 (except n itself) can be a proper divisor.
            for(int previous = 2; previous <= (number / 2); previous++) {
                if(number % previous == 0) {
                    isPrime = false;
                    break; //fast fail we know it is not a prime.
                }
            }
        }
        return isPrime;
    }
}
