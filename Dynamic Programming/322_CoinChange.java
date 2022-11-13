/* 322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 */
class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int  sum = 1, c;
        int [] minVal = new int[amount + 1];
        
        while (sum <= amount)
            minVal[sum++] = amount + 1;
        
        minVal[0] = 0;
        for (sum = 1; sum <= amount; ++sum)
        {
            for (c = 0; c < coins.length; ++c)
                if (coins[c] <= sum)
                    minVal[sum] = Math.min(minVal[sum], 1 + minVal[sum - coins[c]]);
        }
        return minVal[amount] > amount ? -1 : minVal[amount];
    }
}
