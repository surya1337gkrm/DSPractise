package com.surya.leetcode;

import java.util.HashMap;
import java.util.Map;

public class majorityElement {
    public int majority_Element(int[] nums) {
        // Method 01 : Using Hashmap -> Bruteforce

        // Map<Integer, Integer> map = new HashMap<>();
        // int n = nums.length;
        // if (n == 1)
        // return nums[0];
        // for (int i = 0; i < n; i++) {
        // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // // or use this approach instead of above line ->
        // // can avoid re-iterating through
        // // keys
        // // if(map.containsKey(nums[i])){
        // // map.put(nums[i],map.get(nums[i])+1);
        // // if(map.get(nums[i])>n/2) return nums[i];
        // // }else{
        // // map.put(nums[i],1);
        // // }
        // }

        // for (int key : map.keySet()) {
        // if (map.get(key) > n / 2)
        // return key;
        // }

        // return 0;

        // Method02 : Best Approach -> O(n)
        // Approach: Consider the first element as the majority element and start
        // iteraring through the array.
        // if the curr element is equal to el, increment count and if not, decrement
        // count.
        // when count==0, update the el to the i+1th element.

        // at the end, check if el is the majority element, by iteraying through the
        // array and count the occurances of el.
        int el = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (el == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    el = nums[i + 1];
                }
            }
        }

        int c = 0;
        for (int num : nums) {
            if (num == el)
                c++;
        }
        if (c > nums.length / 2)
            return el;

        return -1;
    }
}
