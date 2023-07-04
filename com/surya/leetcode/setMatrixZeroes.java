package com.surya.leetcode;

public class setMatrixZeroes {
    // helper fn 01
    void markRow(int i, int cols, int[][] matrix) {
        for (int j = 0; j < cols; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = 999;
            }
        }
    }

    // helper fn 02
    void markColumn(int j, int rows, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = 999;
            }
        }
    }

    void method01(int[][] matrix) {
        // Approach 01 -> O(n^3) approach
        // iterate through each row & column and if the element is 0, mark the each
        // element in it's row & column as 999.
        // and after completing iterating through the entire matrix, re-iterate and
        // change 999 elements to 0.

        // Issues:
        // 01. Higher Time Complexity.
        // if 999 is already there in given matrix, even that
        // element will be changed to 0.
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    markRow(i, cols, matrix);
                    markColumn(j, rows, matrix);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 999) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void method02(int[][] matrix) {
        // Approach 02 : TC -> O(n*m) , SC: O(m+n)
        // initiate two arrays of length of rows & length of cols
        // whenever there's a 0, update the row & col arrays.
        // After iterating over the entire matrix, based on row & col arrays,
        // update the values in matrix to 0.
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] row = new int[cols];
        int[] col = new int[rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    row[j] = 1;
                    col[i] = 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (row[j] == 1 || col[i] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        method01(matrix); // higher time complexity
        method02(matrix); // higher space complexity

        // Method 03 : O(1) SC
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row0 = -1; // will be used to track if the row 0 has a zero
        // mark when there's a zero in row-0 & col-0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // mark the cols [ oth row in matrix ]
                    matrix[0][j] = 0;
                    // mark the rows [ 0th column in matrix ]
                    if (i > 0) {
                        matrix[i][0] = 0;
                    } else
                        row0 = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // if first element is 0, then mark all elements in col-0 as 0
        if (matrix[0][0] == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        if (row0 == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
