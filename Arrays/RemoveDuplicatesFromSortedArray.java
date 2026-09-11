/*
Problem: Remove Duplicates from Sorted Array

LeetCode: #26
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Problem Statement:
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element
appears only once.

Return the number of unique elements.

Example:
Input:
nums = [1,1,2]

Output:
2

After removing duplicates:
nums = [1,2,_]

The first 2 elements contain the unique values.

Approach:
Use the Two Pointer technique.

1. Keep a pointer 'k' for the position where the next unique
   element should be placed.
2. Start from the second element.
3. If the current element is different from the previous element,
   place it at nums[k] and increment k.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int k = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 3, 3};

        int k = removeDuplicates(nums);

        System.out.println("Number of Unique Elements: " + k);

        System.out.println(
            "Array: " + Arrays.toString(Arrays.copyOf(nums, k))
        );
    }
}