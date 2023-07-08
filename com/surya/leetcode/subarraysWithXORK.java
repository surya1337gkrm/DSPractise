package com.surya.leetcode;

import java.util.*;

public class subarraysWithXORK {
    int betterMethod(int[] nums, int target) {
        // TC: O(n^2) SC: O(1)
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int xr = 0;
            // each individual element can be a subarray
            // a^a=0 | 0^a=a
            for (int j = i; j < nums.length; j++) {
                xr ^= nums[j];
                if (xr == target)
                    count++;
            }
        }
        return count;
    }

    public static int subarraysWithSumK(int[] nums, int target) {
        // optimal approach
        // for every element calculate xor, and check if xor^target exists in the
        // hashmap. simillar to subArrays with sum kl problem.
        // TC: O(n), SC: O(n)
        int count = 0;
        int xr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // initially xor value is 0 with count 1
        for (int i = 0; i < nums.length; i++) {
            xr ^= nums[i];
            // consider 4,2,2,6,4 as input array and target=6
            // in sub-array 4,2,2,6 -> total xor value is 2(xr)
            // let 4 is x and 2,2,6 which has xor value 6
            // x^target=xr
            // xor with target on both sides => (x^target)^target=xr^target => x=xr^target
            if (map.containsKey(xr ^ target)) {
                count += map.get(xr ^ target);
            }
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        return count;
    }
}
