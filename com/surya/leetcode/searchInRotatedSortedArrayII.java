package com.surya.leetcode;

public class searchInRotatedSortedArrayII {
    // Simillar to Search in Rotated Sorted Array Problem but there can be duplicate
    // elements in the Rotated Sorted Array.

    // Using Previous approach will result in error when there are duplicate
    // elements as when we try to limit the search space, sub array can be unsorted
    // to avoud this sitaution , along with the previous approach checks,
    // add a check -> compare low,high and mid elements.
    // if there are equal update low,high and repat the process.
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low += 1;
                high -= 1;
                continue;
            }
            if (nums[low] <= nums[mid]) {
                // low to mid is sorted
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // mid to high is sorted
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
