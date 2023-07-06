package com.surya.leetcode;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangleII {
    int getNcR(int n, int r) {
        long ans = 1;
        r = n - r > r ? r : n - r;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
            ans /= i + 1;
        }
        return (int) ans;
    }

    List<Integer> method01(int rowIndex) {
        // Method 01 : Using extra iteration to calculate nCr
        // as r increases, nCr value grows beyond int range while calculating ans*(i-j)
        // so Store ans value in long variable while calculating.
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            if (i == 0 || i == rowIndex)
                res.add(1);
            else
                res.add(getNcR(rowIndex, i));
        }
        return res;
    }

    public List<Integer> getRow(int rowIndex) {
        // return method01(rowIndex);

        List<Integer> res = new ArrayList<>();
        res.add(1);
        long ans = 1;
        for (int i = 1; i <= rowIndex; i++) {
            ans *= (rowIndex + 1 - i);
            ans /= i;
            res.add((int) ans);
        }
        return res;
    }
}
