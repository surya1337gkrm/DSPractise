package com.surya.leetcode;

public class searchInRotatedSortedArray {
    int bruteForce(int[] nums, int target) {
        // linear search
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        // Method 02 : Modified Binary Search
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            // as the array isn't sorted, we need to modify the binary search approach
            if (nums[low] <= nums[mid]) {
                // low to mid is sorted
                // now check if the target element lies between low & mid
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // mid to right is sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
