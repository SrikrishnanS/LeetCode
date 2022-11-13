/* 1020. Number of Enclaves

You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 */
class Solution 
{
    int nrows;
    int ncols;
    
    private void flood(int [][]grid, int r, int c)
    {
        if (r < 0 || r == nrows ||
            c < 0 || c == ncols ||
            grid[r][c] == 0)
            return;
        
        grid[r][c] = 0;
        flood(grid, r + 1, c);
        flood(grid, r - 1, c);
        flood(grid, r, c + 1);
        flood(grid, r, c - 1);
    }
    
    public int numEnclaves(int[][] grid) 
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
                if (grid[i][j] == 1)
                    ++num;

        return num;
    }
}
