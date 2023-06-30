package com.surya.leetcode;

import java.util.Arrays;

public class longestCommonPrefix {
    public String longest_CommonPrefix(String[] strs) {
        Arrays.sort(strs); // sort the strings array
        String first = strs[0];
        String last = strs[strs.length - 1];

        int index = 0;
        // check each character of first and last string
        while (index < first.length() && index < last.length()) {
            if (first.charAt(index) != last.charAt(index))
                break;
            else
                index++;
        }
        return first.substring(0, index);
    }
}
