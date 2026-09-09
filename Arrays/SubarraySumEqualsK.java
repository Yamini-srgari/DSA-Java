/*
Problem: Subarray Sum Equals K

LeetCode: #560
Link: https://leetcode.com/problems/subarray-sum-equals-k/

Problem Statement:
Given an array of integers nums and an integer k, return the total
number of subarrays whose sum equals k.

A subarray is a contiguous part of the array.

Example:
Input:
nums = [1,1,1]
k = 2

Output:
2

Explanation:
There are two subarrays whose sum is 2:
[1,1] and [1,1].

Approach:
Use Prefix Sum + HashMap.

A prefix sum stores the sum of elements from the beginning
of the array up to the current position.

If:
currentSum - k = previousSum

then the elements between that previous position and the current
position have a sum equal to k.

The HashMap stores:
prefix sum -> number of times that prefix sum has appeared.

We initially store:
0 -> 1

This handles subarrays whose sum starts from index 0.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println("Number of Subarrays: " + subarraySum(nums, k));
    }
}