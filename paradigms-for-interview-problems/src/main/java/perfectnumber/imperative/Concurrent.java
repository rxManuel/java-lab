package perfectnumber.imperative;

import perfectnumber.PerfectNumberDetector;
import java.util.HashSet;
import java.util.Set;

public class Concurrent implements PerfectNumberDetector {

    class DivisorInvestigator extends Thread {
        int start;
        int end;
        Integer number;
        Set<Integer> sharedDivisors;

        DivisorInvestigator(int start, int end, Integer number, Set<Integer> sharedResource) {
            this.start = start;
            this.end = end;
            this.number = number;
            this.sharedDivisors = sharedResource;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                if (number % i == 0) {
                    synchronized (sharedDivisors) {
                        sharedDivisors.add(i);
                        Integer complement = number / i;
                        if (!number.equals(complement) && complement != i) {
                            sharedDivisors.add(complement);
                        }
                    }
                }
            }
        }
    }// Thread

    @Override
    public boolean isPerfectNumber(Integer number) {
        if(number <= 2) {
            return false;
        } else {
            Set<Integer> divisors = new HashSet<>();
            int numOfThreads = 4;
            Thread[] threads = new DivisorInvestigator[numOfThreads];
            int maxDivisor = (int) Math.sqrt(number);
            int rangeSize = ((maxDivisor - 1) / numOfThreads) + 1;// range closed
            for(int i = 0; i < numOfThreads; i++) {
                int start = 1 + i * rangeSize;
                int end = Math.min(start + rangeSize - 1, maxDivisor);
                threads[i] = new DivisorInvestigator(start, end, number, divisors);
                threads[i].start();
            }

            for(Thread investigator : threads) {
                try {
                    investigator.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            Integer sum = 0;
            for(Integer divisor : divisors) {
                sum += divisor;
            }
            return number.equals(sum);
        }
    }
}
