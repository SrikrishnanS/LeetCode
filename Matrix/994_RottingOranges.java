/* 994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

*/

class Solution 
{
    public int orangesRotting(int[][] grid) 
    {
        final int     EMPTY  = 0;
        final int     FRESH  = 1;
        final int     ROTTEN = 2;
        int           nrows = grid.length;
        int           ncols = grid[0].length;
        Queue<int[]>  Q     = new LinkedList<>();
        int           fresh = 0;
        int           mins  = 0;
        int [] []     moves = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
        // first add rotten oranges to the Q
        for (int i = 0; i < nrows; ++i)
            for (int j = 0; j < ncols; ++j)
                if (grid[i][j] == ROTTEN)
                    Q.offer(new int[]{i, j});
                else if (grid[i][j] == FRESH)
                    ++fresh;

        if (fresh == 0)
            return 0;

        // find least time for nearest fresh oranges
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            while ((qSize--) > 0)
            {
                int [] cell = Q.poll();
                
                for (int[] move : moves)
                {
                    int row = move[0] + cell[0];
                    int col = move[1] + cell[1];
                    
                    if (row < 0 || row == nrows  ||
                        col < 0 || col == ncols  ||
                        grid[row][col] == EMPTY  ||
                        grid[row][col] == ROTTEN)
                        continue;

                    grid[row][col] = ROTTEN;
                    --fresh;
                    Q.offer(new int[]{row, col});
                }
            }
            ++mins;
        }
        return (fresh == 0) ? mins - 1 : -1;
    }
}
