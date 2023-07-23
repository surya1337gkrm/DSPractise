package com.surya.leetcode;

public class findFirstAndLastPositionOfElementInSortedArray {
    public int[] bruteForceMethod(int[] nums, int target) {
        // Approach 01: Brute Force
        // Iterate through all elements and update first position when element was found
        // first and then start updating the res[1] when the element is found again.
        int[] res = { -1, -1 };
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (res[0] == -1) {
                    res[0] = i;
                    res[1] = i;
                } else {
                    res[1] = i;
                }
            }
        }
        return res;
    }

    int searchFirst(int[] nums, int target) {
        // basic implementation of binary search
        int low = 0, high = nums.length - 1, ans = -1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                // as we need to find the first occurance of the target,
                // move left to find the first occurance of the target
                high = mid - 1;
            } else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return ans;
    }

    int searchLast(int[] nums, int start, int target) {
        int low = start;
        int ans = start - 1;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                // as we need to find last occurance we need to move right
                low = mid + 1;
            } else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return ans;
    }

    // in this approach we need to create 2 functions which
    // almost does the same thing.
    int[] betterApproach01(int[] nums, int target) {
        int[] res = { -1, -1 };
        res[0] = searchFirst(nums, target);
        if (res[0] == -1)
            return res;
        else {
            res[1] = searchLast(nums, res[0] + 1, target);
        }
        return res;

    }

    int search(int[] nums, int start, int target) {
        int low = start, high = nums.length - 1, ans = start - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                ans = mid;
                // if start is 0, we are checking for the first occurance
                // if not, we are checking for the last occurance
                if (start == 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    // Main Method
    public int[] searchRange(int[] nums, int target) {
        // return bruteForceMethod(nums, target);
        // return betterApproach01(nums, target);
        // Optimised better approach
        int[] res = { -1, -1 };
        res[0] = search(nums, 0, target);
        if (res[0] == -1)
            return res;
        else {
            res[1] = search(nums, res[0] + 1, target);
        }

        return res;

    }
}