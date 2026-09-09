/*
Problem: Longest Consecutive Sequence

LeetCode: #128
Link: https://leetcode.com/problems/longest-consecutive-sequence/

Problem Statement:
Given an unsorted array of integers nums, return the length of the
longest consecutive elements sequence.

The algorithm must run in O(n) time.

Example:
Input:
nums = [100,4,200,1,3,2]

Output:
4

Explanation:
The longest consecutive sequence is [1,2,3,4].
Its length is 4.

Approach:
Use a HashSet.

1. Add all numbers to a HashSet.
2. For every number, check whether num - 1 exists.
3. If num - 1 does not exist, num is the beginning of a sequence.
4. Keep checking num + 1, num + 2, etc.
5. Update the maximum sequence length.

We only start counting when the number is the beginning of a sequence.
This allows us to achieve O(n) time complexity.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Check if num is the start of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(
            "Longest Consecutive Sequence: "
            + longestConsecutive(nums)
        );
    }
}