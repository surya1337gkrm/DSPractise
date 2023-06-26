package com.surya.leetcode;

public class maximumSubarray {
    public int maxSubArray(int[] nums) {
        // Method01: Bruteforce -> When input array size grows,
        // takes too much time to find the solution
        // int n = nums.length;
        // int maxSum = Integer.MIN_VALUE;
        // int sum;

        // for (int i = 0; i < n; i++) {
        // sum = 0;
        // for (int j = i; j < n; j++) {
        // sum += nums[j];
        // maxSum = Math.max(sum, maxSum);
        // }
        // }
        // return maxSum;

        // Method02: O(n) approach
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);

            // if sum is negative, then adding next element will only reduce the total sum.
            // instead, move to the next element. so make sum as 0.
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
