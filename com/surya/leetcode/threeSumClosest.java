package com.surya.leetcode;

import java.util.*;

public class threeSumClosest {
    public int three_Sum_Closest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        // sort the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total == target) {
                    return total;
                } else if (total < target) {
                    // while(j<k && nums[j]==nums[j-1]) j++; -> to avoid duplicates
                    j++;
                } else
                    k--;

                // update closestSum
                if (Math.abs(total - target) < Math.abs(closestSum - target))
                    closestSum = total;
            }
        }
        return closestSum;
    }
}
