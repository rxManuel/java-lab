package primenumber.imperative;

import primenumber.PrimeNumberDetector;

import java.util.concurrent.atomic.AtomicBoolean;



public class Concurrent implements PrimeNumberDetector {

    private class Detective extends Thread {
        int startClue;
        int endClue;
        int criminalNumber;
        AtomicBoolean isCriminal;

        public Detective(int start, int end, int criminalNumber, AtomicBoolean notifier) {
            this.criminalNumber = criminalNumber;
            this.endClue = end;
            this.startClue = start;
            this.isCriminal = notifier;
        }

        @Override
        public void run() {
            for (int divisor = startClue; divisor <= endClue && isCriminal.get(); divisor++) {
                if (criminalNumber % divisor == 0) {
                    isCriminal.set(false); // Found a divisor, mark as not prime
                    break;
                }
            }
        }
    }

    // In order to find the divisors, we will use 4 detectives (threads)
    private static final int DIVISORS_DETECTIVES = 4;

    public boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else {
            // Walkie-talkie used by detectives to notify if a divisor is found
            // Shared communication channel to coordinate the search
            AtomicBoolean isPrime = new AtomicBoolean(true);
            int maxDivisor = (int) Math.sqrt(number);

            Detective[] detectives = new Detective[DIVISORS_DETECTIVES];
            // Each detective (thread) will look in a certain "range"
            int rangeSize = (maxDivisor - 1) / DIVISORS_DETECTIVES + 1;

            for (int i = 0; i < DIVISORS_DETECTIVES; i++) {
                // Build clues for the detectives
                int start = 2 + i * rangeSize;
                int end = Math.min(start + rangeSize - 1, maxDivisor);
                // Give clues to the detectives
                detectives[i] = new Detective(start, end, number, isPrime);
                // Now Detectives can start their investigation
                detectives[i].start();
            }

            // Wait for the detectives to finish their investigation
            for (Detective detective : detectives) {
                try {
                    detective.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return isPrime.get();
        }
    }
}
