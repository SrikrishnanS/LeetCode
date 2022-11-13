/* 1937. Maximum Number of Points with Cost

You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.

To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.

However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.

Return the maximum number of points you can achieve.

abs(x) is defined as:

x for x >= 0.
-x for x < 0. */

class Solution 
{
    public long maxPoints(int[][] points) 
    {
        int  nrows = points.length;
        int  ncols = points[0].length;
        long [][] dp = new long[nrows][ncols];
        long maxPoints = 0;
        
        for (int i = 0; i < ncols; ++i)
            dp[0][i] = points[0][i];
        
        for (int i = 1; i < nrows; ++i)
        {
            long [] left  = new long[ncols];
            long [] right = new long[ncols];
            
            left[0] = dp[i-1][0];
            right[ncols - 1] = dp [i-1][ncols - 1];
            
            for (int j = 1; j < ncols; ++j)
                left[j] = Math.max(left[j-1] - 1, dp[i-1][j]);
            
            for (int j = ncols - 2; j >= 0; --j)
                right[j] = Math.max(right[j+1] - 1, dp[i-1][j]);

            for (int j = 0; j < ncols; ++j)
                dp[i][j] = points[i][j] + Math.max(left[j], right[j]);
        }
        
        for (int j = 0; j < ncols; ++j)
            maxPoints = Math.max(maxPoints, dp[nrows - 1][j]);
        
        return maxPoints;
    }
}
