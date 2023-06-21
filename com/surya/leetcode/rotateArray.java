package com.surya.leetcode;

public class rotateArray {

    private void revArray(int start, int end, int[] arr) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        // Method01: Takes a lot of time when input size os large. O(k*n)
        // Not Preferred
        // if(nums.length==1) return;
        // int count=k%(nums.length);

        // while(count>0){
        // int last=nums[nums.length-1];
        // for(int i=nums.length-1;i>0;i--){
        // nums[i]=nums[i-1];
        // }
        // nums[0]=last;
        // count--;
        // }

        // Method 02: Preferred Method -> Space Complexity : O(1)
        // in place reversing the elements.

        // Example: nums=[1,2,3,4,5,6,7] and k=3
        // Result: [5,6,7,1,2,3,4] which is reverse of [4,3,2,1,7,6,5]

        // where [4,3,2,1] is reverse of n-k elements and [7,6,5] is reverse of last k
        // elements
        if (nums.length == 1)
            return;
        k = k % (nums.length);
        int n = nums.length;

        revArray(0, n - k - 1, nums);
        revArray(n - k, n, nums);
        revArray(0, n - 1, nums);

        // revArray(0,n-1,nums);
        // revArray(0,k-1,nums);
        // revArray(k,n-1,nums);

    }

    private void bruteForceMethod(int[] nums, int k) {
        // Method02 : Brute Force Method
        if (nums.length == 1)
            return;
        int count = k % (nums.length); // if there are 7 elements, and k=8, we have to
                                       // rotate only 1 time as after rotating for 7 times,
                                       // it will be back to original form
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = nums[nums.length - count + i];
        } // storing last k digits in the first k places in the temp array
        for (int i = nums.length - 1; i >= count; i--) {
            nums[i] = nums[i - count];
        } // copying the values from 0-k of nums array to the temp array

        for (int i = 0; i < count; i++) {
            nums[i] = res[i];
        } // copying values from temp array to the nums array
    }

}
