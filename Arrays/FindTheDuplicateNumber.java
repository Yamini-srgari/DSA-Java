/*
Problem: Find the Duplicate Number

LeetCode: #287
Link: https://leetcode.com/problems/find-the-duplicate-number/

Problem Statement:
Given an array nums containing n + 1 integers where each integer
is in the range [1, n] inclusive.

There is only one repeated number, but it may be repeated more
than once.

Return the repeated number.

Example:
Input:
nums = [1,3,4,2,2]

Output:
2

Explanation:
The number 2 appears more than once.

Approach:
Use Floyd's Cycle Detection Algorithm.

Treat each array element as a pointer to another index.

The duplicate number creates a cycle in this structure.

We use two pointers:
1. slow moves one step at a time.
2. fast moves two steps at a time.

First, find where slow and fast meet.
Then reset slow to the beginning and move both pointers
one step at a time.

The point where they meet again is the duplicate number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // Find intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find entrance of the cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};

        System.out.println(
            "Duplicate Number: " + findDuplicate(nums)
        );
    }
}