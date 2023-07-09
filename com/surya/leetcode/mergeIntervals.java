package com.surya.leetcode;

import java.util.*;

public class mergeIntervals {
    int[][] bruteforceMethodOptimized(int[][] intervals) {
        // Method01 : Bruteforce
        // TC : O(nlogn)+ O(2n) as at max all elements will be visited twice
        // as collections will deal with objects, and array is an object
        // List<int[]> is valid.
        List<int[]> res = new ArrayList<>();
        // sort the intervals array
        // check for first element and if they are equal check with 2nd element.
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        // declare two arrays which will be used to store current array and next array
        int[] a, b;
        for (int i = 0; i < intervals.length; i++) {
            // store current array
            a = intervals[i];
            // start from i+1 to check if there's a merged interval
            for (int j = i + 1; j < intervals.length; j++) {
                // store current array
                b = intervals[j];
                // check b[0] < a[1] if yes, intervals are merged
                if (b[0] < a[1]) {
                    a[1] = Math.max(a[1], b[1]);
                    // as b is merged with a, we don't need to check b in the next iteration
                    // so in order to skip b in next iteration, increment i
                    i++;
                } else {
                    // if the condition isn't met, this element will be start of the new interval to
                    // check, if i isn't updated, all the elements until this element will be
                    // checked again. so update i value with j-1, as at the end of this iteration i
                    // will be incremented. so, i will be incremented to j and jth element will be a
                    // and checked with j+1 element.
                    i = j - 1;
                    break;
                }
            }
            res.add(a);
        }
        // either we can create a new array of res.size() size as follows
        // int[][] resArray = new int[res.size()][2];
        // for(int i=0;i<res.size();i++){
        // resArray[i][0]=res.get(i).get(0);
        // resArray[i][1]=res.get(i).get(1);
        // }
        // return resArray;

        // or use .toArray method to convert list to array
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        // Method 02: TC: O(n) and SC:O(n)
        // sort the intervals array
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // check if the list is empty
            // if empty add the current element to the list.
            // if the list isn't empty, check for possibility of merged interval

            if (res.isEmpty() || res.get(res.size() - 1)[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.get(res.size() - 1)[1] = Math.max(intervals[i][1], res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
