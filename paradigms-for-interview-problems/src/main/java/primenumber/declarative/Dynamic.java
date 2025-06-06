package primenumber.declarative;

import primenumber.PrimeNumberDetector;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Dynamic implements PrimeNumberDetector {
    private static List<Integer> primes = new ArrayList<>();

    public boolean isPrime(Integer number) {
        Predicate<Integer> lazyDivisorsChecker =
                n -> (n > 1) && (IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(m -> n % m == 0));
       return primes.contains(number) || // Assumption: .add() method returns true
               // If predicate is true then we add new prime number into cache
               (lazyDivisorsChecker.test(number) ? primes.add(number) : false);
    }
}
