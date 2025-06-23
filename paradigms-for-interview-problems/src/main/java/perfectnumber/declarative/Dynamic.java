package perfectnumber.declarative;

import perfectnumber.PerfectNumberDetector;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Dynamic implements PerfectNumberDetector {

    private static Map<Integer, Integer> perfectNumbers = new HashMap<>();
    @Override
    public boolean isPerfectNumber(Integer number) {
        if(number <= 2)
            return false;
        Function<Integer, Integer> sumOfDivisors =
                n ->   IntStream.rangeClosed(1, (int) Math.sqrt(n))
                .filter(m -> n % m == 0)
                .flatMap(m -> IntStream.of(m, n / m))
                .distinct() // remove duplicated complementary divisors
                .filter(m -> m != n) // remove number itself
                .sum();
        // guess why .equals instead of ==
       return perfectNumbers.computeIfAbsent(number, sumOfDivisors).equals(number);
    }
}
