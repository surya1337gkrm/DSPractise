package com.surya.leetcode;

public class singleNumber {
    public int single_Number(int[] nums) {
        int res = 0;
        // Using XOR
        // a^a=0
        // a^0=a
        for (int n : nums) {
            res = res ^ n;
        }
        return res;
    }
}
