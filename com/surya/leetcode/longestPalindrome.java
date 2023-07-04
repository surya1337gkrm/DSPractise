package com.surya.leetcode;

import java.util.HashMap;
import java.util.Map;

public class longestPalindrome {

    public int method01(String s) {
        // Method 01
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int maxOdd = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // if even, add to res
        // if odd, add even number of characters (total-1) to the res.
        // we can have a middle character which seperates the palindromic equals.
        // so return res + maxOdd
        for (int n : map.values()) {
            if (n % 2 == 0) {
                res += n;
            } else {
                res += (n - 1);
                maxOdd = 1;
            }
        }
        return res + maxOdd;
    }

    int getIndex(char ch) {
        // 0 to 25 : small
        // 26 to 51 : capitals
        if (ch >= 'a' && ch <= 'z')
            return ch - 'a';
        else
            return ch - 'A' + 26;
    }

    public int longest_Palindrome(String s) {
        // return method01(s);
        if (s.length() < 2)
            return s.length();
        // 26 from small - 26 for capitals
        int[] countArr = new int[52];
        int hasOdd = 0;
        int res = 0;
        for (char ch : s.toCharArray()) {
            countArr[getIndex(ch)]++;
        }
        for (int n : countArr) {
            if (n % 2 != 0) {
                res += (n - 1);
                hasOdd = 1;
            } else {
                res += n;
            }
        }

        if (hasOdd == 1)
            res++;

        return res;
    }
}
