package com.surya.leetcode;

import java.util.ArrayList;
// import java.util.HashSet;
import java.util.List;
// import java.util.Set;

public class unionOfSortedArrays {
    // return an array containing only unique elements from both arrays
    private int getLastElement(List<Integer> arr) {
        int found = -1;
        if (arr != null && !arr.isEmpty()) {
            found = arr.get(arr.size() - 1);
        }
        return found;
    }

    public void unionArrays(int[] nums1, int[] nums2) {

        // Method01: BruteForce -> using set
        // Set<Integer> res = new HashSet<>();
        // for (int i = 0; i < nums1.length; i++) {
        // res.add(nums1[i]);
        // }
        // for (int i = 0; i < nums2.length; i++) {
        // res.add(nums2[i]);
        // }

        // // Hashset will sort the elements

        // List<Integer> list = new ArrayList<>(res);
        // list.forEach(el -> System.out.print(el + " "));

        // Method 02: Using Two Pointers

        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (res.size() == 0 || getLastElement(res) != nums1[i]) {
                    res.add(nums1[i]);
                }
                i++;
            } else {
                if (res.size() == 0 || getLastElement(res) != nums2[j]) {
                    res.add(nums2[j]);
                }
                j++;
            }
        }

        while (j < nums2.length) {
            if (res.size() == 0 || getLastElement(res) != nums2[j]) {
                res.add(nums2[j]);
            }
            j++;
        }

        while (i < nums1.length) {
            if (res.size() == 0 || getLastElement(res) != nums1[i]) {
                res.add(nums1[i]);
            }
            i++;
        }

        res.forEach(el -> System.out.print(el + " "));
    }
}
