/*
Problem: Single Number

LeetCode: #136
Link: https://leetcode.com/problems/single-number/

Problem Statement:
Given a non-empty array of integers nums, every element appears twice
except for one element. Find that single element.

Example:
Input:
nums = [2,2,1]

Output:
1

Explanation:
2 appears twice, while 1 appears only once.
Therefore, the single number is 1.

Approach:
Use the XOR operation.

Important XOR properties:
1. x ^ x = 0
2. x ^ 0 = x

When we XOR all elements:
- The numbers that appear twice cancel each other.
- The number that appears once remains.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class SingleNumber {

    public static int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1};

        System.out.println("Single Number: " + singleNumber(nums));
    }
}