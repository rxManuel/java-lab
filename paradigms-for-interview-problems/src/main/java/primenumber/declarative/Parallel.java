package primenumber.declarative;

import primenumber.PrimeNumberDetector;
import java.util.stream.IntStream;

public class Parallel implements PrimeNumberDetector {
    @Override
    public boolean isPrime(Integer n) {
        /*
        IntPredicate tryMeLambda = m -> {
            System.out.println( m + " " + Thread.currentThread().getName());
            return n % m == 0;
        };*/
        return (n > 1) &&
                // no "+ 1" because rangeClosed                                // lambda on fly
                IntStream.rangeClosed(2, (int) Math.sqrt(n)).parallel().filter(m -> n%m == 0).count() == 0;
    }
}
