package com.surya.leetcode;

public class bestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        // Bruteforce : Fails when the prices array size grows significantly
        // int maxProfit = 0;
        // int profit;
        // for (int i = 0; i < prices.length; i++) {
        // for (int j = i + 1; j < prices.length; j++) {
        // profit = prices[j] - prices[i];
        // maxProfit = Math.max(profit, maxProfit);
        // }
        // }
        // return maxProfit;

        int min = prices[0];
        int maxProfit = 0; // when starting, buying n selling on the same day will give max profit as 0.
        int n = prices.length;
        int profit;
        for (int i = 1; i < n; i++) {
            // we need to buy first to sell the stocks.
            profit = prices[i] - min; // current price - previous min stock price.
            maxProfit = Math.max(profit, maxProfit);
            min = Math.min(min, prices[i]); // update the min price
        }
        return maxProfit;
    }
}
