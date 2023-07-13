package com.surya.leetcode;

import java.util.*;

public class globalAndLocalInversions {
    static int gCount;

    boolean bruteforceMethod(int[] nums) {
        // Method 01: Bruteforce
        // TLE -> if input grows, time limit will be exceeded
        int localCount = 0, globalCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    globalCount++;
            }
            if (nums[i] > nums[i + 1])
                localCount++;
        }
        return localCount == globalCount;
    }

    static void mergeSubArrays(int[] arr, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        // temp list to store the sorted elements
        List<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                // global inversion exists
                gCount += mid - left + 1;
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= end) {
            temp.add(arr[right]);
            right++;
        }

        // copying to the original array
        for (int i = start; i <= end; i++) {
            arr[i] = temp.get(i - start);
        }
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int mid = (end - start) / 2 + start;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        mergeSubArrays(arr, start, mid, end);
    }

    boolean betterMethod(int[] nums) {
        // Using Merge sort to count global inversions
        // TC : O(nlogn) + O(n) to count local inversions

        // local inversions
        int lCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i + 1])
                lCount++;
        }

        // counting global inversions
        gCount = 0;
        mergeSort(nums, 0, nums.length - 1);

        return lCount == gCount;

    }

    public boolean isIdealPermutation(int[] nums) {
        // return bruteforceMethod(nums);

        // Optimal Method : TC->O(n)
        // Intution: At max there can be only one global inversion for each element and
        // that should be a local inversion too.
        // only in that case, global inversions and local inversions count can be same.

        // Approach: As we iterate through the array and max is compared with nums[i+1]
        // if its true, i.e there exists a global inversion which isn't a local
        // inversion
        // so the count will not be equal. so return false.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (max > nums[i + 1])
                return false;
            max = Math.max(max, nums[i]);
        }
        return true;

    }
}
