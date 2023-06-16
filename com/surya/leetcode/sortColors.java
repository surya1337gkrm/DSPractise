package com.surya.leetcode;

public class sortColors {
    private void swap(int l, int r, int[] nums) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public void sort_Colors(int[] nums) {
        // nums[mid]==1, ok
        // nums[mid]==2 high--
        // nums[mid]==0 low++
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(mid, high, nums);
                high--;
            }
        }
    }
}
