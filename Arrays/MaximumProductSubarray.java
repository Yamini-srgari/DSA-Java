/*
Problem: Maximum Product Subarray

LeetCode: #152
Link: https://leetcode.com/problems/maximum-product-subarray/

Problem Statement:
Given an integer array nums, find a subarray that has the largest
product, and return the product.

A subarray is a contiguous sequence of elements within an array.

Example:
Input:
nums = [2,3,-2,4]

Output:
6

Explanation:
The subarray [2,3] has the maximum product:
2 * 3 = 6.

Approach:
Keep track of two values:
1. maxProduct - maximum product ending at the current position.
2. minProduct - minimum product ending at the current position.

We need both because multiplying a negative number by the minimum
(negative) product can produce a new maximum product.

If the current number is negative, swap maxProduct and minProduct
before calculating the new values.

For every element:
maxProduct = max(num, maxProduct * num)
minProduct = min(num, minProduct * num)

Keep updating the overall answer using maxProduct.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            if (num < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(num, maxProduct * num);
            minProduct = Math.min(num, minProduct * num);

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};

        System.out.println("Maximum Product: " + maxProduct(nums));
    }
}