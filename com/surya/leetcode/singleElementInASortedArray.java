package com.surya.leetcode;

public class singleElementInASortedArray {
    // Following the leetcode instructions -> Binary Search : O(log n)
    // and space complexity : O(1)
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (mid % 2 != 0) {
                mid -= 1;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
