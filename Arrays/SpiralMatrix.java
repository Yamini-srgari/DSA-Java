/*
Problem: Spiral Matrix

LeetCode: #54
Link: https://leetcode.com/problems/spiral-matrix/

Problem Statement:
Given an m x n matrix, return all elements of the matrix
in spiral order.

Example:
Input:
[
 [1,2,3],
 [4,5,6],
 [7,8,9]
]

Output:
[1,2,3,6,9,8,7,4,5]

Explanation:
The elements are visited in spiral order:
1 → 2 → 3 → 6 → 9 → 8 → 7 → 4 → 5

Approach:
Use four boundaries:
1. top
2. bottom
3. left
4. right

Traverse:
1. Left to right across the top row.
2. Top to bottom along the right column.
3. Right to left across the bottom row.
4. Bottom to top along the left column.

After each traversal, move the corresponding boundary inward.

Time Complexity: O(m * n)
Space Complexity: O(1) excluding the output list.
*/

import java.util.*;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Left to right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // Top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // Bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Spiral Order: " + spiralOrder(matrix));
    }
}