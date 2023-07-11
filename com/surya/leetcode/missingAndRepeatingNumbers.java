package com.surya.leetcode;
// Coding Ninjas problem

import java.util.ArrayList;

public class missingAndRepeatingNumbers {
    int[] bruteforceMethod(ArrayList<Integer> arr, int n) {
        // Method01 :Bruteforce | TC: O(n^2)
        // Iterate through all elements and check
        // current element with all other elements
        // if count >1 then that is the repating element
        // if count=0, then that element is the missing element
        int[] res = new int[2];
        for (int el = 1; el <= n; el++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr.get(i) == el)
                    count++;
            }
            if (count > 1)
                res[1] = el;
            else if (count == 0)
                res[0] = el;
        }
        return res;
    }

    int[] betterApproachUsingHashing(ArrayList<Integer> arr, int n) {
        // Method 02 : Using Hashing
        // Initiate a array of size n+1 to store count of element 1 to n
        // go through each element in the given array and update count in hashedArray
        // count>1 -> repeated | count==0 -> missing number
        int[] res = new int[2];
        int[] hashArray = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hashArray[arr.get(i)]++;
        }
        for (int i = 1; i <= n; i++) {
            if (hashArray[i] > 1)
                res[1] = i;
            else if (hashArray[i] == 0)
                res[0] = i;
        }
        return res;

    }

    public int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // return bruteforceMethod(arr, n);
        return betterApproachUsingHashing(arr, n);
    }
}
