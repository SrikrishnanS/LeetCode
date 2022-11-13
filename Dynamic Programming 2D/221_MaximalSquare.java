/* 221. Maximal Square

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1''s and return its area.
 */
class Solution
{
    public int maximalSquare(char[][] matrix)
    {
        int nrows = matrix.length;
        int ncols = matrix[0].length;
        int [][] dp = new int[nrows][ncols];
        int maxLen  = 0;

        // last column
        for (int i = 0; i < nrows; ++i)
        {
            dp[i][ncols - 1] = matrix[i][ncols - 1] == '1' ? 1 : 0;
            maxLen = Math.max(maxLen, dp[i][ncols - 1]);
        }
        // last row
        for (int j = 0; j < ncols; ++j)
        {
            dp[nrows - 1][j] = matrix[nrows - 1][j] == '1' ? 1 : 0;
            maxLen = Math.max(maxLen, dp[nrows - 1][j]);
        }

        // other cells
        for (int i = nrows - 2; i >= 0; --i)
            for (int j = ncols - 2; j>= 0; --j)
                if (matrix[i][j] == '1')
                {
                    int right  = dp[i][j + 1];
                    int bottom = dp[i + 1][j];
                    int diag   = dp[i + 1][j + 1];

                    dp[i][j] = 1 + Math.min(right, Math.min(bottom, diag));
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
        return maxLen * maxLen;
    }
}
