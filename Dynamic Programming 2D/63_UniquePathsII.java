/* 63. Unique Paths II

You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */
class Solution 
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int i, j;
        int nrows = obstacleGrid.length;
        int ncols = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1 ||
            obstacleGrid[nrows-1][ncols-1] == 1)
            return 0;
        
        obstacleGrid[0][0] = 1; // 1 way for this slot
        
        for (j = 1; j < ncols; ++j) // fill first column values
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 &&
                                  obstacleGrid[0][j-1] == 1) ? 1 : 0;
        for (i = 1; i < nrows; ++i) // fill first row values
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 &&
                                  obstacleGrid[i-1][0] == 1) ? 1 : 0;       
    
        // scan every grid item and update value
        for (i = 1; i < nrows; ++i)
            for (j = 1; j < ncols; ++j)
                obstacleGrid[i][j] =
                  (obstacleGrid[i][j] == 0) ?
                     (obstacleGrid[i-1][j] + obstacleGrid[i][j-1]) : 0;
        return obstacleGrid[nrows-1][ncols-1];
    }
}
