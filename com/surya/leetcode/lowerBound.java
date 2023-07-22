package com.surya.leetcode;

//Problem : Coding Ninjas
// URL: https://www.codingninjas.com/studio/problems/lower-bound_8165382?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

public class lowerBound {
    // n is the size of the array
    // x is the target
    // lower bound -> first occuurance of index where arr[index] >= x
    public static int lower_Bound(int[] arr, int n, int x) {
        // if x is greater than the last element,
        // return length of the array as the answer
        int ans = n;
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            // if arr[mid] >= x, update ans.
            // and update low/high accordingly.
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
