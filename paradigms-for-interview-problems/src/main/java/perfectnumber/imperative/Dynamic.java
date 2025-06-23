package perfectnumber.imperative;

import perfectnumber.PerfectNumberDetector;
import java.util.ArrayList;
import java.util.List;

public class Dynamic implements PerfectNumberDetector {
    private static List<Integer> perfectNumbers = new ArrayList<>();

    public boolean isPerfectNumber(Integer number) {
        if(number <= 2 ){
            return false;
        } else if(perfectNumbers.contains(number)) {
            return true;
        } else {
            List<Integer> divisors = getComplementaryDivisorsOf(number);
            if( getSumOf(divisors) == number){
                perfectNumbers.add(number);
                return true;
            } else {
                return false;
            }
        }
    }

    private int getSumOf(List<Integer> divisors) {
        int subTotal = 0;
        for(Integer divisor : divisors) {
            subTotal += divisor;
        }
        return subTotal;
    }

    private List<Integer> getComplementaryDivisorsOf(Integer number) {
        List<Integer> complementaries = new ArrayList<>();
        complementaries.add(1);
        int maxDivisor =(int) Math.sqrt(number);
        for(int n = 2; n <= maxDivisor; n++) {
            if (number % n == 0) {
                if(n!=number && !complementaries.contains(n)) {
                    complementaries.add(n);
                }
                if(!complementaries.contains( number/n )) {
                    complementaries.add( number/n );
                }
            }
        }
        return complementaries;
    }
}
