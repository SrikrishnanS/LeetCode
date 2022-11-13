/* 200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
class Solution 
{
    char    [][]grid;
    boolean [][]visited;
    int         nrows;
    int         ncols;
    int         islands;

    private void explore(int r, int c)
    {
        if (r < 0 || r == nrows ||
            c < 0 || c == ncols ||
            grid[r][c] == '0' ||
            visited[r][c])
            return;    
        
        visited[r][c] = true; // mark current cell as visited
        explore(r - 1, c);    // explore previous row
        explore(r, c - 1);    // explore previous column
        explore(r + 1, c);    // explore next row
        explore(r, c + 1);    // explore next column
    }
    
    public int numIslands(char[][] grid) 
    {
        this.grid = grid;
        nrows = grid.length;
        ncols = grid[0].length;

        visited = new boolean[nrows][ncols];
        
        for (int i = 0; i < nrows; ++i)
        {
            for (int j = 0; j < ncols; ++j)
            {
                if (!visited[i][j] && grid[i][j] == '1')
                {
                    islands++;
                    explore(i ,j);
                }
            }
        }
        return this.islands;  
    }
}
