package com.surya.leetcode;

public class moveZeroes {
    public void move_Zeroes(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[count] = num;
                count++;
            }
        }
        while (count < nums.length) {
            nums[count] = 0;
            count++;
        }
    }
}
