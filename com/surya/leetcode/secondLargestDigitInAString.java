package com.surya.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class secondLargestDigitInAString {
    public int secondHighest(String s) {
        // Method01 : Using hashset to remove duplicates
        // Set<Integer> res = new HashSet<>();
        // for (int i = 0; i < s.length(); i++) {
        // if (Character.isDigit(s.charAt(i))) {
        // res.add(Character.getNumericValue(s.charAt(i)));
        // }
        // }
        // if (res.size() <= 1)
        // return -1;

        // List<Integer> list = new ArrayList<>(res);
        // Collections.sort(list);
        // int largest = list.get(list.size() - 1);
        // int second = list.get(list.size() - 2);

        // if (largest != second)
        // return second;
        // else
        // return -1;

        // Method02 : O(n) approach
        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i < s.length(); i++) {
            int val = Character.getNumericValue(s.charAt(i));
            if (Character.isDigit(s.charAt(i))) {
                if (val > largest) {
                    secondLargest = secondLargest < largest ? largest : secondLargest;
                    largest = val;
                } else {
                    secondLargest = (val > secondLargest && val != largest) ? val : secondLargest;
                }
            }
        }
        return secondLargest;
    }
}
