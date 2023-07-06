package com.surya.leetcode;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {
    List<List<Integer>> method01(int n) {
        // Method01 : TC: O(n^2) SC: O(n) apart from the list we need to create to
        // return the solution,
        // we need extra space to store the previous index list to add j-1 and jth
        // element to get curr element.
        // jth element in curr list = (j-1)th element + jth element in last list.
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> li = new ArrayList<>();
            List<Integer> lastList = new ArrayList<>();
            if (res.size() != 0)
                lastList = res.get(res.size() - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    li.add(1);
                else
                    li.add(lastList.get(j - 1) + lastList.get(j));
            }
            res.add(li);
        }
        return res;
    }

    int getNcR(int n, int r) {
        int ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
            ans /= (i + 1);
        }
        return ans;
    }

    List<List<Integer>> method02(int n) {
        // ith row, jth column -> i,j starts from 0, then ele(i,j) = iCj
        // if indexing starts from 1, ele(i,j)= (i-1)C(j-1)
        // This approach takes more time as we need to iterate from o to r to find ncr.
        // TC: O(n^3), SC:O(1) apart from the lists we create to return the solution.
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i)
                    li.add(1);
                else
                    li.add(getNcR(i, j));
            }
        }

        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        // return method01(numRows);
        // return method02(numRows);

        // Method 03: Efficient Method -> TC: O(n^2) and SC:O(1)
        // Instead of using ncr method, which will have an additional iteration,
        // element at (ith row, jth column) will be = previous element ((ans)*(i-j))/i
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> li = new ArrayList<Integer>();
            int ans = 1;
            li.add(ans);
            for (int j = 1; j < i; j++) {
                ans *= (i - j) / j;
                li.add(ans);
            }
            res.add(li);
        }
        return res;
    }
}
