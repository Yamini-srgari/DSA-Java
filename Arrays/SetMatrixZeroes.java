/*
Problem: Set Matrix Zeroes

LeetCode: #73
Link: https://leetcode.com/problems/set-matrix-zeroes/

Problem Statement:
Given an m x n integer matrix, if an element is 0, set its entire
row and column to 0.

You must do this in-place.

Example:
Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]

Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Explanation:
The element at row 1, column 1 is 0.
Therefore, its entire row and column become 0.

Approach:
Use the first row and first column as markers.

1. Check whether the first row contains a zero.
2. Check whether the first column contains a zero.
3. For every other cell:
   - If nums[i][j] == 0, mark its row and column by setting
     nums[i][0] = 0 and nums[0][j] = 0.
4. Use these markers to set the required rows and columns to zero.
5. Finally, handle the first row and first column separately.

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check first column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and first column as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set rows to zero
        for (int i = 1; i < rows; i++) {

            if (matrix[i][0] == 0) {

                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set columns to zero
        for (int j = 1; j < cols; j++) {

            if (matrix[0][j] == 0) {

                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (firstRowZero) {

            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle first column
        if (firstColZero) {

            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        setZeroes(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}