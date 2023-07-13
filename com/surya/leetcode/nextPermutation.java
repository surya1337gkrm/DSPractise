package com.surya.leetcode;

public class nextPermutation {
    void reverseArray(int low, int high, int[] arr) {
        int temp;
        while (low < high) {
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public void next_Permutation(int[] nums) {
        int index = -1;
        int n = nums.length;

        // updating the breakpoint index
        // as we need to compare i and i+1 element, start iterating from n-2 element so
        // that first comparision will be n-2 and n-1 element
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            // reverse the entire array if there's no break point
            reverseArray(0, n - 1, nums);
        } else {
            int temp;
            for (int i = n - 1; i >= index; i--) {
                // find the number greater than index element and swap the elements.
                if (nums[i] > nums[index]) {
                    temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
            // reverse the rest of the array from index+1 to end
            reverseArray(index + 1, n - 1, nums);
        }

    }
}
