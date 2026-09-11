/*
Problem: Merge Sorted Array

LeetCode: #88
Link: https://leetcode.com/problems/merge-sorted-array/

Problem Statement:
You are given two integer arrays nums1 and nums2, sorted in
non-decreasing order.

Merge nums2 into nums1 as one sorted array.

nums1 has enough space to hold the elements of nums1 and nums2.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Output:
[1,2,2,3,5,6]

Approach:
Use three pointers from the end.

1. i points to the last element of the valid part of nums1.
2. j points to the last element of nums2.
3. k points to the last position of nums1.

Compare nums1[i] and nums2[j].
Place the larger element at nums1[k] and move the pointers.

Starting from the end prevents us from overwriting elements
already present in nums1.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // Copy remaining elements from nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge(nums1, 3, nums2, 3);

        System.out.println("Merged Array: " + Arrays.toString(nums1));
    }
}