package com.surya.leetcode;

import java.util.ArrayList;
import java.util.List;

public class reversePairs {
    int count = 0;

    int bruteforceMethod(int[] nums) {
        // Method 01 : Bruteforce
        // TC : O(n^2) -> Time limit exceeded.
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // if the elements in the array exceeds the integer range then multiplying with
                // 2 will exceeds the range. So store the result in long variable.
                long res = 2 * (long) nums[j];
                if (nums[i] > res)
                    count++;
            }
        }
        return count;
    }

    void countReversePairs(int[] arr, int start, int mid, int end) {
        int right = mid + 1;
        // for each element in the left array compare with each element in the right
        // array. if the condition is true increment the count
        // if not, break and in the next iteration start from the previous break point.
        // as the each array is already sorted, if ele at ith position satisfies the
        // condition i+1 will also satisfy the condition. So we can skip few iteration
        // and directly start from the previous break point and update the number of
        // elements until the break u[point to the count.
        for (int i = start; i <= mid; i++) {
            while (right <= end && arr[i] > 2 * (long) arr[right])
                right++;
            count += (right - (mid + 1));
        }
    }

    static void mergeSubArrays(int[] arr, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;

        List<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
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
        for (int i = start; i <= end; i++) {
            arr[i] = temp.get(i - start);
        }
    }

    void mergeSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = (end - start) / 2 + start;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        // before merging the sub arrays, we count the number of reverse pairs
        // possible between those 2 sub arrays.
        countReversePairs(arr, start, mid, end);
        mergeSubArrays(arr, start, mid, end);
    }

    public int reverse_pairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        System.gc();
        return count;
    }
}
