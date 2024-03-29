package com.surya.leetcode;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public int[] two_Sum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            }
            map.put(target - nums[i], i);
        }
        return new int[] {};

        // Method02 : Bruteforce
        // for (int i = 0; i < nums.length - 1; i++) {
        // for (int j = i + 1; j < nums.length; j++) {
        // if (nums[i] + nums[j] == target)
        // return new int[] { i, j };
        // }
        // }
        // return new int[] {};
    }
}
