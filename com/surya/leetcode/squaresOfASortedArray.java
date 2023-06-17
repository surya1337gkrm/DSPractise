package com.surya.leetcode;

import java.util.Arrays;

public class squaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        // Method 01: O(nlogn) bcoz of using sort fn
        // for (int i = 0; i < nums.length; i++) {
        // nums[i] = nums[i] * nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;

        // Method02 : Using extra space. Time Complexity: O(n)
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[index] = nums[right] * nums[right];
                right--;
            } else {
                res[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return res;
    }
}
