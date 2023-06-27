package com.surya.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        // Method01 : Using Hashmap
        // TC: O(2n) SC: O(n)
        // Map<Integer, Integer> map = new HashMap<>();
        // List<Integer> res = new ArrayList<>();

        // for (int i = 0; i < nums.length; i++) {
        // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }

        // for (int key : map.keySet()) {
        // if (map.get(key) > (nums.length) / 3) {
        // res.add(key);
        // }
        // }

        // return res;

        // Method 02 : Using O(n) approach same as Majority Element i
        // As we are checking for an element which has freq > n/3, there can be (at max)
        // 2 elements which has freq > n/3.
        List<Integer> res = new ArrayList<>();
        int c1 = 0;
        int c2 = 0;

        int ele1 = -1;
        int ele2 = -1;

        // updating majority elements
        for (int i = 0; i < nums.length; i++) {
            if (c1 == 0 && nums[i] != ele2) {
                ele1 = nums[i];
                c1++;
            } else if (c2 == 0 && nums[i] != ele1) {
                ele2 = nums[i];
                c2++;
            } else if (nums[i] == ele1) {
                c1++;
            } else if (nums[i] == ele2) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        // updating count of elements ele1 & ele2
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1)
                c1++;
            else if (nums[i] == ele2)
                c2++;
        }

        // check if count > n/3 and add elements to the list
        if (c1 > Math.floor(nums.length / 3))
            res.add(ele1);
        if (c2 > Math.floor(nums.length / 3))
            res.add(ele2);

        return res;

    }
}
