package com.surya.leetcode;

public class maxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++; // update count when curr ele is 1
            } else {
                // if curr ele isn't 1, check if curr max value is less than count
                // if yes, update the max value and change count to 0.
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
        }
        // end of the for loop, and check if max is greater than count.
        // if not, update the max value to count.
        if (max < count) {
            max = count;
        }
        return max;
    }
}
