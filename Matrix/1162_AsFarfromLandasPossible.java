/* 1162. As Far from Land as Possible

Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 */
class Solution
{
    public int maxDistance(int[][] grid)
    {
        int            i, j;
        int            nrows    = grid.length;
        int            ncols    = grid[0].length;
        Queue <int[]>  Q        = new LinkedList<int[]>();
        boolean [][]   visited  = new boolean[nrows][ncols];
        int            nsteps   = -1;
        int[][]        moves    = new int[][] {{-1, 0},{1,0},{0,-1},{0,1}};
        for (i = 0; i < nrows; ++i)
            for (j = 0; j < ncols; ++j)
                if (grid[i][j] == 1)
                {
                    Q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
        // explore all cells starting from land in the Q
        // use same Q to add water cells and advance 1 step at a time
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            for (i = 0; i < qSize; ++i)
            {
                int[] cell = Q.poll();
                
                for (int[] move : moves)
                {
                    int r = cell[0] + move[0];
                    int c = cell[1] + move[1];
                    
                    if (r >= 0 && r < nrows &&
                        c >= 0 && c < ncols &&
                        !visited[r][c])
                    {
                        Q.offer(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
            ++nsteps;
        }
        return nsteps < 1 ? -1 : nsteps;
    }
}