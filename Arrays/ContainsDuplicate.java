/*
Problem: Contains Duplicate

LeetCode: #217
Link: https://leetcode.com/problems/contains-duplicate/

Problem Statement:
Given an integer array nums, return true if any value appears
at least twice in the array, and return false if every element
is different.

Example 1:
Input:  nums = [1,2,3,1]
Output: true

Explanation:
The number 1 appears more than once.

Example 2:
Input:  nums = [1,2,3,4]
Output: false

Explanation:
Every number appears only once.

Approach:
Use a HashSet to store the numbers we have already seen.
If a number is already present in the HashSet, return true.
Otherwise, add it to the HashSet.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        System.out.println(containsDuplicate(nums));
    }
}