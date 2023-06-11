package com.surya.math;

import java.util.*;

public class MathFun {
    public static List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<Integer>();
        while (n>0) {
            digits.add(n % 10);
            n = n / 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static int getLength(int n) {
        return Integer.toString(n).length();
    }
}
