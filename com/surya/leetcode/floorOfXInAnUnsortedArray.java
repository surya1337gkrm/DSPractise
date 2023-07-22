package com.surya.leetcode;

import java.util.*;

//Problem : Floor of target(x) in the unsorted array
public class floorOfXInAnUnsortedArray {
    public int floor(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1, floor = -1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                floor = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }
}
