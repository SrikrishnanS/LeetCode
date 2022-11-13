/*
778. Swim in Rising Water

You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

*/

class Solution
{
    public int swimInWater(int[][] grid)
    {
        int          n       =  grid.length;
        Queue<int[]> Q;
        int [][]     moves;
        boolean [][] visited = new boolean[n][n];
        int          d       = 0;

        moves   = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // [0, 1]: cell coordinate  [2] : max distance so far
        Q = new PriorityQueue<int[]>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);

        visited[0][0] = true;
        Q.offer(new int[]{0, 0});

        while (!Q.isEmpty())
        {
            int [] cell = Q.poll();
            int    r    = cell[0];
            int    c    = cell[1];

            d = Math.max(d, grid[r][c]);
            if ((r == n - 1) && (c == n - 1))
                return d;

            // examine next possible moves
            for (int [] move : moves)
            {
                int x = r + move[0];
                int y = c + move[1];

                if (x < 0 || x == n || y < 0 || y == n ||
                    visited[x][y])
                    continue;

                visited[x][y] = true;
                Q.offer(new int[]{x, y});
            }
        }
        return -1;
    }
}