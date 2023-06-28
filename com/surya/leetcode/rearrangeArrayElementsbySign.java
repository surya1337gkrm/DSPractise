package com.surya.leetcode;

public class rearrangeArrayElementsbySign {
    public int[] rearrangeArray(int[] nums) {
        // Method01: Bruteforce -> Using two n/2 length arrays
        // to store +ve & -ve elements
        // And create a temp array of length n, and iterate from o to n/2 ans store +ve
        // and -ve elements simultaneously
        // int l = nums.length;
        // int[] p = new int[l / 2];
        // int[] n = new int[l / 2];

        // int[] temp = new int[l];
        // int p1 = 0;
        // int p2 = 0;

        // for (int i = 0; i < l; i++) {
        // if (nums[i] > 0) {
        // p[p1] = nums[i];
        // p1++;
        // } else {
        // n[p2] = nums[i];
        // p2++;
        // }
        // }

        // for (int i = 0; i < l / 2; i++) {
        // temp[2 * i] = p[i];
        // temp[(2 * i) + 1] = n[i];
        // }

        // return temp;

        // Method 02 : Without creating +ve & -ve arrays
        int l = nums.length;

        int[] temp = new int[l];
        int p1 = 0; // number of positives : also acts as index for +ve elements in temp array
        int p2 = 0; // number of negatives : also acts as index for -ve elements in temp array

        for (int i = 0; i < l; i++) {
            if (nums[i] > 0) {
                temp[2 * p1] = nums[i];
                p1++;
            } else {
                temp[2 * p2 + 1] = nums[i];
                p2++;
            }
        }
        return temp;
    }
}
