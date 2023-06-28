package com.surya.leetcode;

public class maximumProductSubarray {
    public int maxProduct(int[] nums) {
        // Bruteforce
        // int maxProduct = Integer.MIN_VALUE;
        // int product;

        // for (int i = 0; i < nums.length; i++) {
        // product = 1;
        // for (int j = i; j < nums.length; j++) {
        // product *= nums[j];
        // maxProduct = Math.max(product, maxProduct);
        // }
        // }

        // return maxProduct;

        // Intuition: When there are even number of negative numbers / complete positive
        // numbers
        // then the product of total elements will be the solution.

        // if there is a zero, array will be splitted into parts (before and after 0)
        // and answer can be from the sub array before 0 or after 0

        // Simillarly when there are odd number of negative numbers, maximum product can
        // be from array before the negative number (prefix array) or after negative
        // number (suffix array).

        // Method02 : Using Prefix & Suffix products
        // int prefixProduct = 1;
        // int suffixProduct = 1;

        // int maxProduct = Integer.MIN_VALUE;

        // for (int i = 0; i < nums.length; i++) {
        // if (prefixProduct == 0)
        // prefixProduct = 1;
        // prefixProduct *= nums[i];
        // maxProduct = Math.max(maxProduct, prefixProduct);
        // }

        // for (int i = nums.length - 1; i >= 0; i--) {
        // if (suffixProduct == 0)
        // suffixProduct = 1;
        // suffixProduct *= nums[i];
        // maxProduct = Math.max(maxProduct, suffixProduct);
        // }

        // return maxProduct;

        // Method03 : Same as previous but using single for loop
        int prefixProduct = 1;
        int suffixProduct = 1;

        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prefixProduct == 0)
                prefixProduct = 1;
            if (suffixProduct == 0)
                suffixProduct = 1;

            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
        }

        return maxProduct;
    }
}
