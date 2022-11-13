/*
562. Longest Line of Consecutive One in Matrix

Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.

The line could be horizontal, vertical, diagonal, or anti-diagonal.

*/

class Solution 
{
    public int longestLine(int[][] mat) 
    {
        int         nrows   = mat.length;
        int         ncols   = mat[0].length;
        int [][][]  dp      = new int[nrows][ncols][4];
        // 0: left, 1: up, 2: diag, 3: anti-diag
        int         maxLen  = 0;
        int         a, b, c, d;
        
        for (int i = 0; i < nrows; ++i)
        {
            for (int j = 0; j < ncols; ++j)
            {
                if (mat[i][j] == 1)
                {
                    dp[i][j][0] = (j > 0) ? dp[i][j - 1][0] + 1 : 1;
                    dp[i][j][1] = (i > 0) ? dp[i - 1][j][1] + 1 : 1;
                    dp[i][j][2] = (i > 0 && j < ncols - 1) ? dp[i - 1][j + 1][2] + 1 : 1;
                    dp[i][j][3] = (i > 0 && j > 0) ? dp [i - 1][j - 1][3] + 1 : 1;
                
                    a = dp[i][j][0];
                    b = dp[i][j][1];
                    c = dp[i][j][2];
                    d = dp[i][j][3];
                    maxLen = Math.max(maxLen, 
                                Math.max(a, 
                                    Math.max(b, 
                                        Math.max(c, d))));
                }
            }
        }
        return maxLen;
    }
}
