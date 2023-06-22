package com.surya.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        List<Integer> res = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        int[] resArray = new int[res.size()];
        for (int c = 0; c < resArray.length; c++) {
            resArray[c] = res.get(c);
        }

        return resArray;
    }
}
