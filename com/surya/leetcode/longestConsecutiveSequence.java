package com.surya.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveSequence {
    // boolean search(int[] arr, int ele) {
    // for (int num : arr) {
    // if (num == ele)
    // return true;
    // }
    // return false;
    // }

    public int longestConsecutive(int[] nums) {
        // Method01: Bruteforce
        // iterate through each element and check if ele+1 exists in the array using
        // linear search. initiate the count to 1 as current element will be the first
        // element.
        // int maxCount = 0;
        // for (int i = 0; i < nums.length; i++) {
        // int count = 1;
        // int currEle = nums[i] + 1;
        // while (search(nums, currEle)) {
        // count++;
        // currEle++;
        // }
        // maxCount = Math.max(maxCount, count);
        // count = 1;
        // }
        // return maxCount;

        // ---------------- Method 02: Sorting the elements ----------------
        // Time Complexity : O(nlogn) to sort the elements and O(n) to iterate over them
        // if (nums.length < 2)
        // return nums.length;
        // Arrays.sort(nums);
        // int maxCount = 1;
        // int i = 0;// pointer to the curr element
        // int count = 1;
        // while (i < nums.length - 1) {
        // // check if nect element is equal to prev element+1. if yes, increment count.
        // if (nums[i] + 1 == nums[i + 1]) {
        // count++;
        // } else if (nums[i] != nums[i + 1]) {
        // // checking for duplicate consecutive elements.
        // // if there are any duplicates, we will not do anything.
        // // update count value to 1 if consecutive elements aren't equal.
        // count = 1;
        // }
        // i++;
        // maxCount = Math.max(maxCount, count);
        // }

        // return maxCount;

        // --------------Method 03 : Using O(3n) approach
        if (nums.length < 2)
            return nums.length;
        int maxCount = 1;

        Set<Integer> set = new HashSet<>();

        // add all elements of the nums array to the set. [removing duplicate elements]
        for (int n : nums) {
            set.add(n);
        }

        int count;
        for (int currEle : set) {
            // check if current element-1 exists in the set.
            // if it doesnt exist, start counting if consecutive elements exists.
            if (!set.contains(currEle - 1)) {
                count = 1;
                while (set.contains(currEle + 1)) {
                    count++;
                    currEle++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;

    }
}
