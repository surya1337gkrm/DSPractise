package com.surya.leetcode;

public class findMinimumInRotatedSortedArray {
    // Method 01 : O(n) Approach
    int bruteForceMethod(int[] nums) {
        int min = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

    // Method 02: Using binary Search -> TC :O(log n)
    int betterApproach01(int[] nums) {
        int min = Integer.MAX_VALUE, low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[low] <= nums[mid]) {
                // low to mid is sorted
                // update min to nums[low]
                min = Math.min(min, nums[low]);
                // as low to mid is sorted and min is updated
                // we can ignore low to mid subarray
                low = mid + 1;
            } else {
                // mid to high is sorted
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    // Method 03 -> Simillar to Method 02 with an additional step
    int betterApproach02(int[] nums) {
        int min = Integer.MAX_VALUE, low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[low] <= nums[mid] && nums[mid] <= nums[high]) {
                // low to high sorted
                min = Math.min(min, nums[low]);
                low = mid + 1;
                high = mid - 1;
            } else if (nums[low] <= nums[mid]) {
                // low to mid is sorted
                // update min to nums[low]
                min = Math.min(min, nums[low]);
                // as low to mid is sorted and min is updated
                // we can ignore low to mid subarray
                low = mid + 1;
            } else {
                // mid to high is sorted
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    public int findMin(int[] nums) {
        // return bruteForceMethod(nums);
        return betterApproach01(nums);
        // return betterApproach02(nums);
    }
}
