package com.surya.leetcode;

public class fibonacciNumber {
    public int fib(int n) {
        if (n < 2)
            return n;

        int[] fibArr = new int[n + 1];
        fibArr[0] = 0;
        fibArr[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }
        return fibArr[n];
    }
}
