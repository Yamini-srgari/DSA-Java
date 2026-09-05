/*
Problem: Best Time to Buy and Sell Stock

LeetCode: #121
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Problem Statement:
You are given an array of prices where prices[i] is the price
of a stock on the ith day.

You can choose one day to buy the stock and a different day in
the future to sell it.

Return the maximum profit you can achieve.
If no profit is possible, return 0.

Example:
Input:  prices = [7,1,5,3,6,4]
Output: 5

Explanation:
Buy at price 1 and sell at price 6.
Profit = 6 - 1 = 5.

Approach:
1. Keep track of the minimum price seen so far.
2. Calculate the profit for each day's price.
3. Keep track of the maximum profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            minPrice = Math.min(minPrice, prices[i]);

            int profit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }
}