/* 1905. Count Sub Islands

You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.
 */
class Solution 
{
    int[][] grid1;
    int[][] grid2;
    int nrows, ncols;
    
    public boolean walk(int r, int c)
    {
        if (r < 0 || r == nrows ||
            c < 0 || c == ncols ||
            grid2[r][c] == 0)
            return true;
        
        if (grid2[r][c] == grid1[r][c])
        {
            boolean result = true;

            grid2[r][c] = 0;
            result &= walk(r + 1, c);
            result &= walk(r - 1, c);
            result &= walk(r, c + 1);
            result &= walk(r, c - 1);
            // need to walk each of the neighbors, so can't short-
            // circuit the above using a single statement.
            return result;
        }
        return false;
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) 
    {
        int i, j;
        int islands = 0;
        this.grid1 = grid1;
        this.grid2 = grid2;
        this.nrows = grid2.length;
        this.ncols = grid2[0].length;
        
        
        for (i = 0; i < nrows; ++i)
            for (j = 0; j < ncols; ++j)
                if (grid2[i][j] == 1 && walk(i, j))
                    ++islands;
        return islands;
    }
}
