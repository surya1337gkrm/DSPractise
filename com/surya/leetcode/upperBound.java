package com.surya.leetcode;

public class upperBound {
    // upper bound: index -> first occurance when arr[index]>x
    public static int upper_bound(int[] arr, int n, int x) {
        int ans = n;
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
