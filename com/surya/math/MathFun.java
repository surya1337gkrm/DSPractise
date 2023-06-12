package com.surya.math;

import java.util.*;

public class MathFun {
    public static List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<Integer>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static int getLength(int n) {
        return Integer.toString(n).length();
    }

    public int getCommonFactors(int a, int b) {
        int count = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        for (int i = 1; i <= Math.sqrt(min); i++) {
            if (min % i == 0) {
                if (max % i == 0)
                    count++;
                if (min / i != i && max % (min / i) == 0)
                    count++;
            }
        }
        return count;
    }
}
