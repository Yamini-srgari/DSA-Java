/*
Problem: Sort Colors

LeetCode: #75
Link: https://leetcode.com/problems/sort-colors/

Problem Statement:
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.

We use:
0 = red
1 = white
2 = blue

Example:
Input:
nums = [2,0,2,1,1,0]

Output:
[0,0,1,1,2,2]

Approach:
Use the Dutch National Flag Algorithm.

Maintain three pointers:
1. low  -> position for 0
2. mid  -> current element
3. high -> position for 2

Rules:
- If nums[mid] == 0:
    swap nums[low] and nums[mid]
    low++
    mid++

- If nums[mid] == 1:
    mid++

- If nums[mid] == 2:
    swap nums[mid] and nums[high]
    high--
    Do NOT increment mid because the swapped element
    still needs to be checked.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }

            else if (nums[mid] == 1) {
                mid++;
            }

            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        System.out.println("Sorted Colors: " + Arrays.toString(nums));
    }
}