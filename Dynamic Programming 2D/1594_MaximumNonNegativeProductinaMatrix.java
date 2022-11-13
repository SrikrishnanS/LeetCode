/*
1594. Maximum Non Negative Product in a Matrix

You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.

Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (m - 1, n - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.

Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative, return -1.

Notice that the modulo is performed after getting the maximum product.

*/

class Solution 
{
    public int maxProductPath(int[][] grid) 
    {
        int  nrows = grid.length;
        int  ncols = grid[0].length;
        long maxLen = 0;
        long[][][] dp = new long[nrows][ncols][2];
        // <row, col, m> m: 0 -> min, 1 -> max positive product
        
        dp[0][0][0] = dp[0][0][1] = grid[0][0];

        for (int j = 1; j < ncols; ++j)
        {
            dp[0][j][0] = grid[0][j] * dp[0][j - 1][0];
            dp[0][j][1] = grid[0][j] * dp[0][j - 1][1];
        }
        
        for (int i = 1; i < nrows; ++i)
        {
            dp[i][0][0] = grid[i][0] * dp[i - 1][0][0];
            dp[i][0][1] = grid[i][0] * dp[i - 1][0][1];
        }
        
        for (int i = 1; i < nrows; ++i)
        {
            for (int j = 1; j < ncols; ++j)
            {
                int  val = grid[i][j];
                long min = Math.min(dp[i - 1][j][0], dp[i][j - 1][0]);
                long max = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]);
                
                if (val < 0) // val is neg
                {
                    dp[i][j][0] = max * val; // minimize negative value
                    dp[i][j][1] = min * val; // maximize positive value
                }
                else
                {
                    dp[i][j][0] =  min * val; // minimize negative value
                    dp[i][j][1] =  max * val; // maximize positive value
                }
            }
        }
        maxLen = dp[nrows - 1][ncols - 1][1];
        return (maxLen < 0) ? -1 : (int)(maxLen % (1000000000 + 7));
    }
}
