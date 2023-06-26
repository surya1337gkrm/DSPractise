package com.surya.leetcode;

import java.util.ArrayList;
import java.util.List;

public class kthMissingPositiveInteger {
    private int bruteforceSol1(int[] arr, int k) {
        // Method01: Bruteforce
        // initiated an array of length arr.length+k and filled the array with
        // 1-(arr.length+k) values.
        int[] temp = new int[arr.length + k];
        for (int i = 1; i <= temp.length; i++) {
            temp[i - 1] = i;
        }

        // initiate 2 pointers. i points to arr and j points to temp array

        int i = 0;
        int j = 0;

        List<Integer> res = new ArrayList<>();

        while (i < arr.length && j < temp.length) {
            // as both arrays are sorted, if ith element is greater than jth element of temp
            // array we don't need to check further. ele at jth index is missing
            // add to the res list.
            if (arr[i] > temp[j]) {
                res.add(temp[j]);
                j++;
            } else if (arr[i] == temp[j]) {
                i++;
                j++;
            }
        }

        while (j < temp.length) {
            res.add(temp[j]);
            j++;
        }
        return res.get(k - 1);
    }

    private int bruteforceSol2(int[] arr, int k) {
        // iterate through the array and if the arr[i] <=k, increment k
        // and if arr[i]>k, return k.
        // This approach takes O(n) time complexity & O(1) space complexity
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            } else {
                return k;
            }
        }
        return k;
    }

    public int findKthPositive(int[] arr, int k) {
        // return bruteforceSol1(arr, k);
        // return bruteforceSol2(arr, k);

        // Method 03: Binary Search : TC->O(log n)
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + (high - low)) / 2;

            // missing numbers before each index = element at curr index - index+1
            int missingNumbers = arr[mid] - (mid + 1);

            if (missingNumbers < k) {
                // if missingNunbers is less than k, that means kth missing
                // number exists next to low boundary
                // increment low to mid+1
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // after loop is done, both low & high will be updated and kth missing
        // number lies between low & high.

        // missing numbers after index before kth = k-(arr[high]-high-1)
        // kth missing element = arr[high]+ missing numbers after index before kth
        // = arr[high]+k-(arr[high]-high-1)
        // = k+high+1 = k+low (as low=high+1 at the end of loop )

        return low + k;
    }
}
