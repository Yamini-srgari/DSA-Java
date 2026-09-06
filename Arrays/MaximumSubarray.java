/*
Problem: Maximum Subarray

LeetCode: #53
Link: https://leetcode.com/problems/maximum-subarray/

Problem Statement:
Given an integer array nums, find the subarray with the largest sum
and return its sum.

Example:
Input:  nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6

Explanation:
The subarray [4,-1,2,1] has the largest sum.
Sum = 4 + (-1) + 2 + 1 = 6

Approach:
Use Kadane's Algorithm.
Keep track of the current subarray sum and the maximum sum found.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }
}