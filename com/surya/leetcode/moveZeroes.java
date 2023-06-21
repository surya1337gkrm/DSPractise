package com.surya.leetcode;

public class moveZeroes {
    public void move_Zeroes(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[count] = num;
                count++;
            }
        }
        while (count < nums.length) {
            nums[count] = 0;
            count++;
        }

        // Method02
        // int j = -1;
        // // find the first occurrence of 0.
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] == 0) {
        // j = i;
        // break;
        // }
        // }
        // // return if there are no 0s in the array.
        // if (j == -1)
        // return;
        // int temp;
        // // keep the first pointer(i) next to the first 0. and swap
        // for (int i = j + 1; i < nums.length; i++) {
        // if (nums[i] != 0) {
        // temp = nums[i];
        // nums[i] = nums[j];
        // nums[j] = temp;
        // j++;
        // }
        // }
    }
}
