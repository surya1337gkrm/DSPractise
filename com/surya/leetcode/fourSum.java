package com.surya.leetcode;

import java.util.*;

public class fourSum {
    List<List<Integer>> bruteForceMethod(int[] nums, int target) {
        // Bruteforce Approach : TC -> O(n^4) | Not Preferred
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        int total = nums[i] + nums[j] + nums[k] + nums[l]; // if numbers are large, we need to store in
                                                                           // long variable instead
                        if (total == target) {
                            List<Integer> li = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(li); // sort the list and check if the result set contains li
                            if (!res.contains(li))
                                res.add(li);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    List<List<Integer>> betterMethod(int[] nums, int target) {
        // Using set to store the list of 4 integers that has sum = target
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // create a set to store integers
                // that we will use to check if fourth element i.e,
                // target- sum of first 3 elements exists
                Set<Long> set = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    // if element is large, adding elements might exceed the int range
                    // so storing in long variable
                    long sum = nums[i] + nums[j];
                    sum += nums[k]; // or long sum = (long)nums[i]+(long)nums[j]+(long)nums[k];
                    long l = target - sum;
                    if (set.contains(l)) {
                        List<Integer> li = Arrays.asList(nums[i], nums[j], nums[k], (int) l);
                        // sort the li before storing in the res set.
                        Collections.sort(li);
                        res.add(li);
                    }
                    // add nums[k] to the set
                    set.add((long) nums[k]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public List<List<Integer>> four_Sum(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            // avoid duplicates
            if (!(i > 0 && nums[i] == nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (!(j > i + 1 && nums[j] == nums[j - 1])) {
                        int k = j + 1;
                        int l = nums.length - 1;
                        while (k < l) {
                            // as array can consist large numbers and adding might cause an overflow
                            long sum = nums[i] + nums[j];
                            sum += nums[k];
                            sum += nums[l];
                            if (sum == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                                k++;
                                l--;
                                // avoid duplicates
                                while (k < l && nums[k] == nums[k - 1])
                                    k++;
                                while (k < l && nums[l] == nums[l + 1])
                                    l--;
                            } else if (sum < target)
                                k++;
                            else {
                                l--;
                            }

                        }
                    }
                }
            }
        }
        return res;
    }
}
