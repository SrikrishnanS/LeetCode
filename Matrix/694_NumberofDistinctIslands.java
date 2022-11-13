/* 694. Number of Distinct Islands

You are given an m x n binary matrix grid. An island is a group of 1s (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Return the number of distinct islands.
 */
class Solution 
{
    public int numDistinctIslands(int[][] grid) 
    {
        int          nrows   = grid.length;
        int          ncols   = grid[0].length;
        boolean [][] visited = new boolean[nrows][ncols];
        Set<String>  set     = new HashSet<String>();
    
        for (int i = 0; i < nrows; ++i)
        {
            for (int j = 0; j < ncols; ++j)
            {
                StringBuilder path = new StringBuilder();
       
                exploreDistinctIslands(grid, i, j, path, 'S', visited);
                if (path.length() > 0)
                    set.add(path.toString());
            }
        }
        return set.size();
    }

    private void exploreDistinctIslands(int [][]grid, int r, int c,
                                        StringBuilder path, char dir,
                                        boolean[][] visited)
    {
        if (r < 0 || r == grid.length ||
            c < 0 || c == grid[0].length ||
            visited[r][c] || grid[r][c] == 0)
            return;
        
        visited[r][c] = true;
        path.append(dir);
        exploreDistinctIslands(grid, r + 1, c, path, 'D', visited);
        exploreDistinctIslands(grid, r - 1, c, path, 'U', visited);
        exploreDistinctIslands(grid, r, c + 1, path, 'R', visited);
        exploreDistinctIslands(grid, r, c - 1, path, 'L', visited);
        path.append('E');
    }
}
