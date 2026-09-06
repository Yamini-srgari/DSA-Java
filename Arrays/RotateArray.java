/*
Problem: Rotate Array

LeetCode: #189
Link: https://leetcode.com/problems/rotate-array/

Problem Statement:
Given an integer array nums, rotate the array to the right by k steps.

Example:
Input:  nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

Explanation:
Rotate right by 1:
[7,1,2,3,4,5,6]

Rotate right by 2:
[6,7,1,2,3,4,5]

Rotate right by 3:
[5,6,7,1,2,3,4]

Approach:
Use the reversal technique:
1. Reverse the entire array.
2. Reverse the first k elements.
3. Reverse the remaining elements.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class RotateArray {

    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}