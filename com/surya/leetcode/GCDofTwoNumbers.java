package com.surya.leetcode;

public class GCDofTwoNumbers {
    public int gcd(int num1, int num2) {
        // Approach 01
        // int min = Math.min(num1, num2);
        // int gcd = 1;
        // // instead of looping through increment, loop using decrement so that we
        // cover
        // // maximum value first
        // // and if we got the gcd we don't have to calcuate min numbers
        // for (int i = min; i > 1; i--) {
        // if (num1 % i == 0 && num2 % i == 0) {
        // gcd = i;
        // break; // break the loop when the condition was satisfied for the first time
        // as we are
        // // considering max nums first
        // }
        // }
        // return gcd;

        // approach 02 -> Euclidean Theorem
        // gcd(a,b) when a>b, will be equal to gcd(a%b,b) and we can repeat this until
        // one of the number is 0.
        // then the other number will be the gcd.

        while (num1 > 0 && num2 > 0) {
            if (num1 > num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }
        if (num1 == 0)
            return num2;
        return num1;
    }
}
