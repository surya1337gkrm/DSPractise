package com.surya.leetcode;

public class armstrongNumber {
    // ArmStrongNumber -> sum of each digit to the power of total number of digits results in the same number
    // 371 -> 3^3+7^3+1^3 [ as there are 3 digits, we have to cube them ] 
    public boolean isArmstrongNumber(int num) {
        int res = 0;
        int temp = num;
        int lastDigit = 0;
        int digitCount = Integer.toString(num).length();
        while (temp > 0) {
            lastDigit = temp % 10;
            res += Math.pow(lastDigit, digitCount);
            temp = temp / 10;
        }
        System.out.println(String.format("%d,%d", res, num));
        return num == res;
    }
}
