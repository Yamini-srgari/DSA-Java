/*
Problem: Missing Number

LeetCode: #268
Link: https://leetcode.com/problems/missing-number/

Problem Statement:
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Example:
Input:  nums = [3,0,1]
Output: 2

Explanation:
The numbers in the range [0,3] are 0, 1, 2, 3.
The number 2 is missing from the array.

Approach:
Use the XOR operation.

XOR has two important properties:
1. x ^ x = 0
2. x ^ 0 = x

By XORing all numbers from 0 to n with all elements
in the array, the duplicate numbers cancel out.
The remaining number is the missing number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MissingNumber {

    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int result = n;

        for (int i = 0; i < n; i++) {
            result ^= i;
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};

        System.out.println("Missing Number: " + missingNumber(nums));
    }
}