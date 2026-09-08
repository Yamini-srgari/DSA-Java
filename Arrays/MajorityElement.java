/*
Problem: Majority Element

LeetCode: #169
Link: https://leetcode.com/problems/majority-element/

Problem Statement:
Given an array nums of size n, return the element that appears
more than n/2 times.

You may assume that the majority element always exists.

Example:
Input:  nums = [2,2,1,1,1,2,2]
Output: 2

Explanation:
2 appears 4 times, which is more than n/2 (7/2 = 3).
Therefore, the majority element is 2.

Approach:
Use the Boyer-Moore Voting Algorithm.

We maintain:
1. candidate - the current possible majority element.
2. count - the number of votes for the candidate.

If count becomes 0, we choose the current element as the new candidate.
If the current element is equal to the candidate, increase count.
Otherwise, decrease count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MajorityElement {

    public static int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Majority Element: " + majorityElement(nums));
    }
}