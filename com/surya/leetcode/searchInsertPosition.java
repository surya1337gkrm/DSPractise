package com.surya.leetcode;

public class searchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // if last element of the array is less than the target
        // we need to add the element at the end of the array
        if (nums[nums.length - 1] < target)
            return nums.length;
        int low = 0, high = nums.length - 1, ans = nums.length, mid;
        // implement lower bound
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.gc(); // garbage collector
        return ans;
    }
}
