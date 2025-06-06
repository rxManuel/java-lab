package primenumber.declarative;

import primenumber.PrimeNumberDetector;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Classical implements PrimeNumberDetector {
    public boolean isPrime(Integer number) {
        IntPredicate isDivisibleLambda = m -> number % m == 0;

        return (number > 1) &&
                IntStream.range(2, (int)Math.sqrt(number) + 1).filter(isDivisibleLambda).count() == 0;
    }
}
