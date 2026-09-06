/*
Problem: Move Zeroes

LeetCode: #283
Link: https://leetcode.com/problems/move-zeroes/

Problem Statement:
Given an integer array nums, move all 0's to the end of the array
while maintaining the relative order of the non-zero elements.

You must do this in-place without making a copy of the array.

Example:
Input:  [0,1,0,3,12]
Output: [1,3,12,0,0]

Approach:
Use a pointer to keep track of the position where the next
non-zero element should be placed.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}