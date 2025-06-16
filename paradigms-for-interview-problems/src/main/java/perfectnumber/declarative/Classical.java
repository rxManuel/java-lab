package perfectnumber.declarative;

import perfectnumber.PerfectNumberDetector;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Classical implements PerfectNumberDetector {
    @Override
     public boolean isPerfectNumber(Integer number) {
        IntPredicate isDivisible = m -> number % m == 0;
        IntFunction<IntStream> mapToComplementaryDivisors = m -> IntStream.of(m, number / m);
        return (number > 2 )  &&
              IntStream.range(1, (int) Math.sqrt(number) + 1)
                      .filter(isDivisible)
                      .flatMap(mapToComplementaryDivisors)
                      .distinct() // remove duplicated complementary divisors
                      .filter(m -> m != number) // remove number itself
                      .sum() == number;
    }
}
