/* 1254. Number of Closed Islands

Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.
 */
class Solution 
{
    int nrows;
    int ncols;
    
    private void flood(int [][]grid, int r, int c)
    {
        if (r < 0 || r == nrows ||
            c < 0 || c == ncols ||
            grid[r][c] == 1)
            return;
        
        grid[r][c] = 1;
        flood(grid, r + 1, c);
        flood(grid, r - 1, c);
        flood(grid, r, c + 1);
        flood(grid, r, c - 1);
    }
    public int closedIsland(int[][] grid)
    {
        int num = 0;

        nrows = grid.length;
        ncols = grid[0].length;
        
        // first flood from the border cells
        // fill all reachable cells with water
        for (int i = 0; i < nrows; ++i)
            for (int j = 0; j < ncols; ++j)
                if ((i * j == 0) || (i == nrows -1) || (j == ncols - 1))
                    flood(grid, i, j);
    
        // count remaining land cells
        for (int i = 1; i < nrows; ++i)
            for (int j = 1; j < ncols; ++j)
                if (grid[i][j] == 0)
                {
                    flood(grid, i, j); // count number of patches, not cells
                    ++num;
                }

        return num;
    }
}
