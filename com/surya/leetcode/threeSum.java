package com.surya.leetcode;

import java.util.*;

public class threeSum {
    List<List<Integer>> bruteForceMethod(int[] nums) {
        // Method 01: Bruteforce approach
        // check for each element and before inserting into the list,
        // check if sorted li exists
        // TC: O(n^3) -> when nums length increases,
        // time takes to return the sol will be higher
        // Not Recommended
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> li;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        li = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(li); // generally sorting will take nlogn
                                              // but as the li will always have 3 elements,
                                              // sorting will take constant time, so we can avoid taking nlogn
                        if (!res.contains(li))
                            res.add(li);
                    }
                }
            }
        }
        return res;
    }

    List<List<Integer>> betterMethod01(int[] nums) {
        // TC: O(n^3) -> n^2 for iterating and O(n) for checking if list exists in the
        // res list.
        // Not Preferred for large inputs.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> li;

        for (int i = 0; i < nums.length - 2; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int k = -1 * (nums[i] + nums[j]);
                if (set.contains(k)) {
                    li = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(li);
                    // this takes higher time as contains method takes O(n)
                    // where as in set, in takes O(1)
                    if (!res.contains(li)) {
                        res.add(li);
                    }
                }
                set.add(nums[j]);
            }
        }
        return res;
    }

    List<List<Integer>> betterMethod02(int[] nums) {
        // TC:O(n^2)
        // Better method than using lists but still takes high time.
        Set<List<Integer>> resSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int k = -(nums[i] + nums[j]);
                if (set.contains(k)) {
                    List<Integer> li = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(li);
                    resSet.add(li); // adding to set takes O(1) and also takes O(1) to search in hashset
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(resSet);
    }

    public List<List<Integer>> three_Sum(int[] nums) {
        // return bruteForceMethod(nums);
        List<List<Integer>> res = new ArrayList<>();
        // Sort the array so that we can increment/decrement
        // pointers based on +ve/-ve sum
        Arrays.sort(nums);
        int sum;
        for (int i = 0; i < nums.length; i++) {
            // if adjacent elements are same, triplets will be same
            if (!(i > 0 && nums[i] == nums[i - 1])) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) {
                        // if sum is -ve, we need to increment j
                        // as array is already sorted, resultant sum will be increased towards 0
                        j++;
                    } else if (sum > 0) {
                        // if sum is +ve, we need to decrement k
                        // as array is already sorted, resultant sum will be decreased towards 0
                        k--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;

                        // check if adjacent elements are same - avoid duplicates
                        // as if we consider duplicates, there will be duplicate triplets
                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                        while (j < k && nums[k] == nums[k + 1])
                            k--;

                    }
                }
            }
        }
        return res;
    }
}
