package com.surya.leetcode;

import java.util.ArrayList;
import java.util.List;

public class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Method01: using extra space (O(n)) -> temp array
        // List<Integer> arr = new ArrayList<>();
        // int l = 0;
        // int r = 0;
        // while (l < m && r < n) {
        // if (nums1[l] < nums2[r]) {
        // arr.add(nums1[l]);
        // l++;
        // } else {
        // arr.add(nums2[r]);
        // r++;
        // }
        // }

        // while (l < m) {
        // arr.add(nums1[l]);
        // l++;
        // }

        // while (r < n) {
        // arr.add(nums2[r]);
        // r++;
        // }

        // for (int i = 0; i < nums1.length; i++) {
        // nums1[i] = arr.get(i);
        // }

        // Method02 -> Without using extra space
        int last = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[last] = nums2[n - 1];
                n--;
            } else {
                nums1[last] = nums1[m - 1];
                m--;
            }
            last--;
        }
        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }
    }
}
