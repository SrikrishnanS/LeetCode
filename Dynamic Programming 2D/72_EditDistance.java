/* 72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 */
class Solution 
{
    public int minDistance(String word1, String word2) 
    {
        int m = word1.length();
        int n = word2.length();
        int [][] dp = new int[m + 1][n + 1];
    
        for (int j = 0; j <= n; ++j)
            dp[m][j] = n - j;

        for (int i = 0; i <= m; ++i)
            dp[i][n] = m - i;
    
        for (int i = m - 1; i >= 0; --i)
            for (int j = n - 1; j >= 0; --j)
            {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else
                {
                    int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    min = Math.min(min, dp[i + 1][j + 1]);
                    dp[i][j] = 1 + min;
                }
            }
        return dp[0][0];
    }
}
