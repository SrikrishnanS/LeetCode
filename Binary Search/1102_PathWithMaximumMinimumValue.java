/*
1102. Path With Maximum Minimum Value

Given an m x n integer matrix grid, return the maximum score of a path starting at (0, 0) and ending at (m - 1, n - 1) moving in the 4 cardinal directions.

The score of a path is the minimum value in that path.

For example, the score of the path 8 → 4 → 5 → 9 is 4.

*/

class Solution 
{
    public int maximumMinimumPath(int[][] grid) 
    {
        int  nrows = grid.length;
        int  ncols = grid[0].length;
        int  l     = 0;
        int  r     = Math.min(grid[0][0], grid[nrows - 1][ncols - 1]);
    
        // find upper bound
        while (l < r)
        {
            int m = r - ((r - l) / 2);

            if (hasPath(grid, 0, 0, m, new boolean[nrows][ncols]))
                l = m;
            else
                r = m - 1;
        }
        return l;
    }
    
    private boolean hasPath(int[][]grid, int r, int c, int min,
                            boolean[][] visited)
    {
        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length ||
            visited[r][c] || grid[r][c] < min)
            return false; // out of bounds or already visited
        else if (r == grid.length - 1 && c == grid[0].length - 1)
            return true; // destination reached
    
        visited[r][c] = true;
        return hasPath(grid, r + 1, c, min, visited) ||
               hasPath(grid, r, c + 1, min, visited) ||
               hasPath(grid, r - 1, c, min, visited) ||
               hasPath(grid, r, c - 1, min, visited);
    }
}
