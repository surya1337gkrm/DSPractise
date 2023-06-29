package com.surya.leetcode;

public class replaceElementswithGreatestElementonRightSide {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int temp;
        // as final element will always be -1
        // store curr element in temp and change curr element value to max value
        // and update max value
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = max;
            if (max < temp)
                max = temp;
        }
        return arr;
    }
}
