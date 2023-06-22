package com.surya.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashSet;
import java.util.List;
// import java.util.Set;

public class intersectionOfTwoArrays {
    int getLastElement(List<Integer> arr) {
        int found = -1;
        if (arr != null && !arr.isEmpty()) {
            found = arr.get(arr.size() - 1);
        }
        return found;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        // Method01 : Bruteforce Approach -> using hashset to remove duplicates.
        // Set<Integer> set = new HashSet<>();
        // for (int i = 0; i < nums1.length; i++) {
        // set.add(nums1[i]);
        // }
        // Set<Integer> res = new HashSet<>();
        // for (int el : nums2) {
        // if (set.contains(el) && !res.contains(el)) {
        // res.add(el);
        // }
        // }

        // return res.stream().mapToInt(el -> el.intValue()).toArray();

        // Method 02 : Sorting two arrays and using two pointers
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j] && getLastElement(res) != nums1[i]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else {
                j++;
            }
        }

        // return res.stream().mapToInt(el -> el.intValue()).toArray();
        // using streams takes more space & memory

        int[] resArray = new int[res.size()];
        for (int a = 0; a < resArray.length; a++) {
            resArray[a] = res.get(a);
        }
        return resArray;
    }
}
