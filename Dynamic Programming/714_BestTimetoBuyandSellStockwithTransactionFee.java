/* 714. Best Time to Buy and Sell Stock with Transaction Fee

You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
class Solution
{
    public int maxProfit(int[] prices, int fee)
    {
        int [] buy  = new int[prices.length];
        int [] sell = new int[prices.length];
        
        buy[0]  = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; ++i)
        {
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }
}
