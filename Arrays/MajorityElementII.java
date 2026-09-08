/*
Problem: Majority Element II

LeetCode: #229
Link: https://leetcode.com/problems/majority-element-ii/

Problem Statement:
Given an integer array nums of size n, return all elements that
appear more than n/3 times.

Example:
Input:
nums = [3,2,3]

Output:
[3]

Explanation:
The array has 3 elements.
n/3 = 1.
The number 3 appears twice, which is more than 1.

Approach:
Use the Boyer-Moore Voting Algorithm with two candidates.

There can be at most two elements that appear more than n/3 times.

We maintain:
1. candidate1 and count1
2. candidate2 and count2

First pass finds the possible candidates.
Second pass verifies their actual frequencies.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0;
        int candidate2 = 1;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            } 
            else if (num == candidate2) {
                count2++;
            } 
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } 
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } 
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }

            if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }

        if (count2 > nums.length / 3 && candidate1 != candidate2) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 3};

        System.out.println("Majority Elements: " + majorityElement(nums));
    }
}