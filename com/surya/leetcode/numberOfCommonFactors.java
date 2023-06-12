package com.surya.leetcode;

public class numberOfCommonFactors {
    public int commonFactors(int a, int b) {
        int count = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        for (int i = 1; i <= Math.sqrt(min); i++) {
            if (min % i == 0) {
                // check if both numbers are divisible by i
                if (max % i == 0)
                    count++;
                // if min is divisible and max isn't check, if min/i divided max num.
                if (min / i != i && max % (min / i) == 0)
                    count++;
            }
        }
        return count;
    }
}
