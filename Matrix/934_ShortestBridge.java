/* 934. Shortest Bridge

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0''s you must flip to connect the two islands.
 */
class Solution
{
    int          nrows;
    int          ncols;
    boolean[][]  visited;
    int [][]moves = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};

    public int shortestBridge(int[][] grid)
    {
        int          i = 0, j = 0;
        int          nsteps = -1;
        Queue<int[]> Q;
     
        nrows   = grid.length;
        ncols   = grid[0].length;
        visited = new boolean[nrows][ncols];
        Q       = new LinkedList<int[]>();

        for (i = 0; i < nrows; ++i)
        {
            if (!Q.isEmpty())
                break;
            for (j = 0; j < ncols; ++j)
            {
                if (grid[i][j] == 1)
                {
                    nsteps = 0;
                    explore(grid, i, j, Q);
                    break;
                }
            }
        }
        
        if (nsteps < 0)
            return 0;
        
        // (i,j) is a land cell, explore it        
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            for (int n = 0; n < qSize; ++n)
            {
                int[] cell = Q.poll();
                
                for (int[] move: moves)
                {
                    i = cell[0] + move[0];
                    j = cell[1] + move[1];

                    if (i < 0 || i == nrows ||
                        j < 0 || j == ncols ||
                        visited[i][j])
                        continue;
                    else if (grid[i][j] == 1)
                        return nsteps;

                    visited[i][j] = true;
                    Q.offer(new int[]{i, j});
                }
            }
            ++nsteps;
        }
        return -1;
    }
    private void explore(int [][]grid, int r, int c, Queue<int[]> Q)
    {
        if (r < 0 || r == nrows ||
            c < 0 || c == ncols ||
            visited[r][c] || grid[r][c] != 1)
            return;

        visited[r][c] = true;
        Q.offer(new int[]{r, c});
        for (int[] move: moves)
            explore(grid, r + move[0], c + move[1], Q);
    }
}
