package perfectnumber;
//A perfect number is a positive integer that is equal to the sum of its proper divisors, excluding itself.
// For example, 6 is a perfect number because its proper divisors (1, 2, and 3) add up to 6
public interface PerfectNumberDetector {
    boolean isPerfectNumber(Integer n);
}
