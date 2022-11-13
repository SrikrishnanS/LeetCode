/*
361. Bomb Enemy

Given an m x n matrix grid where each cell is either a wall 'W', an enemy 'E' or empty '0', return the maximum enemies you can kill using one bomb. You can only place the bomb in an empty cell.

The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since it is too strong to be destroyed.

*/

class Solution
{
    public int maxKilledEnemies(char[][] grid)
    {
        char ENEMY = 'E', EMPTY = '0', WALL = 'W';

        int m = grid.length;
        int n = grid[0].length;
        int i, j;
        int [][] dp = new int[m][n];
        int maxHits = 0;

        // left to right
        for (i = 0; i < m; ++i)
        {
            int rowHit = 0;
            for (j = 0; j < n; ++j)
            {
                if (grid[i][j] == ENEMY)
                    ++rowHit;
                else if (grid[i][j] == WALL)
                    rowHit = 0;
                else if (grid[i][j] == EMPTY)
                    dp[i][j] = rowHit;
            }
        }

        // right to left
        for (i = m - 1; i >= 0; --i)
        {
            int rowHit = 0;
            for (j = n - 1; j >= 0; --j)
            {
                if (grid[i][j] == ENEMY)
                    ++rowHit;
                else if (grid[i][j] == WALL)
                    rowHit = 0;
                else if (grid[i][j] == EMPTY)
                    dp[i][j] += rowHit;
            }
        }

        // top to bottom
        for (j = 0; j < n; ++j)
        {
            int colHit = 0;
            for (i = 0; i < m; ++i)
            {
                if (grid[i][j] == ENEMY)
                    ++colHit;
                else if (grid[i][j] == WALL)
                    colHit = 0;
                else if (grid[i][j] == EMPTY)
                    dp[i][j] += colHit;
            }
        }

        // bottom to top
        for (j = n - 1; j >= 0; --j)
        {
            int colHit = 0;
            for (i = m - 1; i >= 0; --i)
            {
                if (grid[i][j] == ENEMY)
                    ++colHit;
                else if (grid[i][j] == WALL)
                    colHit = 0;
                else if (grid[i][j] == EMPTY)
                    dp[i][j] += colHit;

                maxHits = Math.max(maxHits, dp[i][j]);
            }
        }
        return maxHits;
    }
}
