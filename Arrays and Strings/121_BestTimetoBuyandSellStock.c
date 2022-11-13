/*
121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

*/

int maxProfit(int* prices, int pricesSize)
{
    int  minPrice  = prices[0];
    int  maxProfit = 0;

    for (int i = 1; i < pricesSize; ++i)
    {
        if (prices[i] - minPrice > maxProfit)
            maxProfit = prices[i] - minPrice;
        if (prices[i] < minPrice)
            minPrice = prices[i];
    }
    return maxProfit;
}
