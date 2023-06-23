package com.surya.leetcode;

import java.util.ArrayList;
import java.util.List;

public class intersectionOfMultipleArrays {
    int maxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    public List<Integer> intersection(int[][] nums) {
        int max = maxElement(nums[0]);

        List<Integer> res = new ArrayList<>();
        int[] freq = new int[max + 1]; // either use max+1 array or simply initialize with 1001 [ as per the leetcode
                                       // problem]

        // iterate through each element and increment the count based on the element
        // value [ element value will be the index.]
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] <= max) {
                    freq[nums[i][j]]++;
                }
            }
        }

        int n = nums.length;
        for (int i = 0; i < freq.length; i++) {
            // if count of value is equal to length of the array then add the element to the
            // list.
            if (freq[i] == n) {
                res.add(i);
            }
        }

        return res;
    }
}
