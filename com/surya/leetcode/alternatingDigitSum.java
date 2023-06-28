package com.surya.leetcode;

public class alternatingDigitSum {
    public int alternateDigitSum(int n) {
        int res = 0;
        String s = Integer.toString(n);
        int val;
        for (int i = 0; i < s.length(); i++) {
            val = Character.getNumericValue(s.charAt(i));
            if (i % 2 == 0) {
                res += val;
            } else {
                res -= val;
            }
        }
        return res;
    }
}
