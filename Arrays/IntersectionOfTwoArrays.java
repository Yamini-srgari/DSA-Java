/*
Problem: Intersection of Two Arrays

LeetCode: #349
Link: https://leetcode.com/problems/intersection-of-two-arrays/

Problem Statement:
Given two integer arrays nums1 and nums2, return an array of their
intersection.

Each element in the result must be unique.
The result can be returned in any order.

Example:
Input:
nums1 = [1,2,2,1]
nums2 = [2,2]

Output:
[2]

Explanation:
The only common element between the two arrays is 2.
Duplicates are removed from the result.

Approach:
Use a HashSet.

1. Store all elements of nums1 in a HashSet.
2. Traverse nums2.
3. If an element exists in the HashSet, add it to the result.
4. Remove the element from the set after adding it so that duplicates
   are not added to the result.

Time Complexity: O(n + m)
Space Complexity: O(n)
*/

import java.util.*;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> result = new HashSet<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int[] answer = new int[result.size()];

        int i = 0;
        for (int num : result) {
            answer[i++] = num;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);

        System.out.println("Intersection: " + Arrays.toString(result));
    }
}