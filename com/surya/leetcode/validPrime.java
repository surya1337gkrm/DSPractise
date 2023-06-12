package com.surya.leetcode;

public class validPrime {
    public boolean isValidPrime(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++;
                if (num / i != i)
                    count++;
            }
        }
        return count == 2;
    }
}
