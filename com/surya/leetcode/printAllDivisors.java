package com.surya.leetcode;

import java.util.ArrayList;
import java.util.List;

public class printAllDivisors {
    public void printDivisors(int num) {
        // Approach 01 -> BruteForce
        // for (int i = 1; i <= num; i++) {
        // if (num % i == 0) {
        // System.out.println(i);
        // }
        // }

        // Approach 02
        // consider looping until sqrt of the number as beyond that num, numbers grow
        // and divisors will be repeated.
        List<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                divisors.add(i);
                if (num / i != i) {
                    divisors.add(num / i);
                }
            }
        }
        divisors.sort(null);
        divisors.forEach(el -> System.out.println(el));
    }
}
