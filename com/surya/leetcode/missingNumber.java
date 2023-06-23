package com.surya.leetcode;

public class missingNumber {
    public int missing_Number(int[] nums) {
        int n = nums.length;
        int sum = (int) (n * (n + 1) * 0.5);

        for (int i : nums) {
            sum = sum - i;
        }
        return sum;
    }
}
