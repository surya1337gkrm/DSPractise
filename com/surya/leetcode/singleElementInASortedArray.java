package com.surya.leetcode;

public class singleElementInASortedArray {
    // Method 01 : O(n)
    int bruteForceMethod(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // if there's no single element, then return -1
        int res = -1, index = 0;
        // check current element with the next element
        // if they are same incremeny by 2 [skip next element]
        // if not, then current element is the single element we need
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                res = nums[i];
                return res;
            }
            index += 1;
        }
        // index will be incremented during each iteration.
        // as i is incremented by 2, we might miss last element.
        // if last element is the single element, then return last element
        if (index < nums.length - 1) {
            return nums[nums.length - 1];
        }
        return res;
    }

    // using XOR
    int bruteForceMethod02(int[] nums) {
        // a^a =0
        // 0^a = a
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public int singleNonDuplicate(int[] nums) {
        // Following the leetcode instructions -> Binary Search : O(log n)
        // and space complexity : O(1)
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            // until the single element is found, equal pairs will be in (even,odd)
            // positions. So, always check for even & odd position elements if they are
            // equal. if mid isn't even, then update mid to its previous value and check
            // mid and mid+1 elements. if they are equal update low to mid+2 [ skipping
            // mid+1 element]. if not, then shrink the range by updating high to mid.
            if (mid % 2 != 0) {
                mid -= 1;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
