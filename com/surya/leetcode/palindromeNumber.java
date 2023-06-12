package com.surya.leetcode;

public class palindromeNumber {
    public boolean isPalindrome(int x) {
        // negative numbers aren't palindromes so we can skip.
        if (x < 0)
            return false;
        int rev = 0;
        int lastDigit = 0;
        int temp = x;

        while (temp > 0) {
            lastDigit = temp % 10;
            temp = temp / 10;
            // didnt check for overflow as if there's overflow, number will change and it
            // will not be a palindrome
            rev = (rev * 10) + lastDigit;
        }
        return rev == x;

    }
}
