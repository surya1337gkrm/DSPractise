package com.surya.leetcode;

import java.util.Arrays;

public class ceilOfX {
    public static int ceil(int[] nums, int target) {
        // sort the array
        Arrays.sort(nums);
        int ceil = -1, low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ceil = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;

    }
}
