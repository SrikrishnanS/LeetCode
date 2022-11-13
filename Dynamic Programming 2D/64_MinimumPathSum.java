/* 64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int nrows = grid.length;
        int ncols = grid[0].length;
        int i, j;
        
        for (j = 1; j < ncols; ++j)
            grid[0][j] += grid[0][j-1];
        
        for (i = 1; i < nrows; ++i)
            grid[i][0] += grid[i-1][0];
        
        for (i = 1; i < nrows; ++i)
            for (j = 1; j < ncols; ++j)
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
    
        return grid[nrows - 1][ncols - 1];
    }
}
