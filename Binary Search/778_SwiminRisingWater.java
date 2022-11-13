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
        int  n = grid.length;
        int  l = grid[0][0];
        int  r = n * n; //  per the constraints given in the problem

        // answer lies between l and r
        // find the lower bound using binary search
        while (l < r)
        {
            int m = l + ((r - l)/ 2);

            if (canSwim(grid, m, n))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    private boolean canSwim(int[][] grid, int max, int n)
    {
        // start from (0, 0)
        return canSwim(grid, 0, 0, max, n, new boolean[n][n]);
    }

    private boolean canSwim(int[][] grid, int r, int c, int max, int n,
                            boolean [][] visited)
    {
        int [][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        if ((r == n - 1) && (c == n - 1))
            return true; // destination reached

        visited[r][c] = true;

        for (int [] move : moves)
        {
            // find next possible moves
            int x = r + move[0];
            int y = c + move[1];

            if (x < 0 || x == n || y < 0 || y == n ||
                visited[x][y] || grid[x][y] > max)
                continue; // not possible
            else if (canSwim(grid, x, y, max, n, visited))
                return true;
        }
        return false;
    }
}
