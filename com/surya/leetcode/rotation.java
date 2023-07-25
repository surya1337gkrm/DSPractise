package com.surya.leetcode;

//Problem URL: https://www.codingninjas.com/studio/problems/rotation_7449070
// find how many times the array is rotated.
public class rotation {
    int bruteForceMethod(int[] arr) {
        // Find the index at which the next element is lesser than the current element
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                res = i + 1;
        }
        return res;
    }

    int betterApproach(int[] arr) {
        // Simillar to finding the minumum element in the rotated sorted array
        // number of rotations = index value of the minimum element
        int min = Integer.MAX_VALUE, low = 0, high = arr.length - 1, mid, res = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[low] <= arr[mid] && arr[mid] <= arr[high]) {
                // low to high sorted
                if (arr[low] < min) {
                    min = arr[low];
                    res = low;
                }
                low = mid + 1;
                high = mid - 1;
            } else if (arr[low] <= arr[mid]) {
                // low to mid is sorted
                // update min to arr[low]
                if (arr[low] < min) {
                    min = arr[low];
                    res = low;
                }
                // as low to mid is sorted and min is updated
                // we can ignore low to mid subarray
                low = mid + 1;

            } else {
                // mid to high is sorted
                if (arr[mid] < min) {
                    min = arr[mid];
                    res = mid;
                }
                high = mid - 1;
            }
        }
        return res;
    }

    public int findKRotation(int[] arr) {
        return bruteForceMethod(arr);
    }
}
