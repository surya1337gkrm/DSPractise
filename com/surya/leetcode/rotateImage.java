package com.surya.leetcode;

public class rotateImage {
    void bruteforceApproach(int[][] matrix) {
        // create a new matrix of same size as the original matrix
        // iterate through the matrix and copy the element to the
        // correct position in the copy matrix.
        // Old position : [i,j] -> [j,n-i-1] where n is the matrix.length
        int n = matrix.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = matrix[i][j];
            }
        }

        // copying the copy matrix to the original matrix.
        // modifying the original matrix.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }

    void reverse(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public void rotate(int[][] matrix) {
        // bruteforceApproach(matrix);

        // Method 02 : Transpose the matrix and reverse each row
        // transpose of the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            // reverse each row after transpose
            reverse(matrix[i]);
        }
    }
}
