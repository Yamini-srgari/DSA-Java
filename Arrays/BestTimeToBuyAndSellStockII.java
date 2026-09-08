/*
Problem: Best Time to Buy and Sell Stock II

LeetCode: #122
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Problem Statement:
You are given an array prices where prices[i] is the price of a
given stock on the ith day.

You can buy and sell the stock multiple times, but you must sell
the stock before buying again.

Return the maximum profit you can achieve.

Example:
Input:
prices = [7,1,5,3,6,4]

Output:
7

Explanation:
Buy at 1 and sell at 5 -> profit = 4.
Buy at 3 and sell at 6 -> profit = 3.
Total profit = 7.

Approach:
Use a greedy approach.

Whenever today's price is greater than yesterday's price,
we take that profit.

If prices[i] > prices[i - 1]:
    profit += prices[i] - prices[i - 1]

This captures every profitable upward movement.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Maximum Profit: " + maxProfit(prices));
    }
}