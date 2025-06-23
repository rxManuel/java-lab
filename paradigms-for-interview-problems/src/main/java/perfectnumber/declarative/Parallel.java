package perfectnumber.declarative;

import perfectnumber.PerfectNumberDetector;

import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Parallel implements PerfectNumberDetector {
    @Override
    public boolean isPerfectNumber(Integer number) {
        IntFunction<IntStream> parallelMapToComplementaryDivisors = m -> IntStream.of(m, number / m).parallel();
        return (number > 2 )  &&
                IntStream.range(1, (int) Math.sqrt(number) + 1)
                        .parallel()
                        .filter(m -> number%m == 0)
                        .flatMap(parallelMapToComplementaryDivisors)
                        .distinct() // remove duplicated complementary divisors
                        .filter(m -> m != number) // remove number itself
                        .sum() == number;
    }
}
