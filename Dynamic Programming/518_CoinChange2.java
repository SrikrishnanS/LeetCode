/* 518. Coin Change 2

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.
 */
class Solution
{
    public int change(int amount, int[] coins)
    {
        int [] nways = new int[amount + 1];
    
        nways[0] = 1;
        for (int n = 0; n < coins.length; ++n)
            for (int sum = 1; sum <= amount; ++sum)
                if (sum >= coins[n])
                    nways[sum] += nways[sum - coins[n]];
        return nways[amount];
    }
}
