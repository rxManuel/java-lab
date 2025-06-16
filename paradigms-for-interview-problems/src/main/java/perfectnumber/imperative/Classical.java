package perfectnumber.imperative;

import perfectnumber.PerfectNumberDetector;

public class Classical implements PerfectNumberDetector {

    @Override
    public boolean isPerfectNumber(Integer number) {
        boolean isPerfect = false;
        if(number > 1) {
            int subTotal = 0;
            // Although iterating until sqrt(number) is more efficient,
            // we iterate until number / 2 to illustrate the concept:
            // no number greater than n/2 (except n itself) can be a proper divisor.
            for(int n = 1; n <= number/2; n++) {
                if(number % n == 0) {
                    subTotal += n;
                }
            }
            isPerfect = subTotal == number;
        }
        return isPerfect;
    }
}
