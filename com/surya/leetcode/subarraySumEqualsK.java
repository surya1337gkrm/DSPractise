package com.surya.leetcode;

import java.util.HashMap;
import java.util.Map;

public class subarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // Method 01: Bruteforce -> When input size grows,
        // takes too much of time to execute.
        // Not preferred
        // int count = 0;
        // int sum;
        // for (int i = 0; i < nums.length; i++) {
        // sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum = sum + nums[j];
        // if (sum == k) {
        // count++;
        // // don't break the loop when sum==k, as we need to check further
        // // if the next values contribute to a sum 0, then resultant sum will be equal
        // to
        // // k and that can be a valid sub array
        // }
        // }
        // }
        // return count;

        // Method 02 : Using Hashmap -> Time Complexity : O(n), Space Complexity : O(n)
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // map takes sum as key and count as value
        // Here, we are adding an item to the map initially.
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // find if there's sum-k as a key in the map.
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // add sum,count to the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
