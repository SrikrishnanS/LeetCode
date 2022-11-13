/*
1293. Shortest Path in a Grid with Obstacles Elimination

You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 */

 class Visit
{
    int   row;
    int   col;
    int   obstacles;

    public Visit(int r, int c, int k)
    {
        this.row = r;
        this.col = c;
        this.obstacles = k;
    }

    public int hashCode()
    {
        return (this.row + 1) * (this.col + 1) * this.obstacles;
    }
    public boolean equals(Object visit)
    {
        Visit v;
        if (!(visit instanceof Visit))
            return false;

        v = (Visit) visit;
        return ((v.row == this.row) && (v.col == this.col) &&
                (v.obstacles == this.obstacles));
    }
}

class Solution
{
    public int shortestPath(int[][] grid, int k)
    {
        int nrows       = grid.length;
        int ncols       = grid[0].length;
        Queue<Visit> Q  = new LinkedList<Visit>();
        int  nsteps     = 0;
        int [][] moves  = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
        Set<Visit> seen = new HashSet<>();

        if (grid[0][0] == 1 || grid[nrows - 1][ncols - 1] == 1)
            return -1;

        // add starting cell to the Q
        Visit start = new Visit(0, 0, 0);
        seen.add(start);
        Q.offer(start);

        while (!Q.isEmpty())
        {
            int  qSize = Q.size();

            while ((qSize--) > 0)
            {
                Visit  v = Q.poll();
                int    r = v.row;
                int    c = v.col;
                int    o = v.obstacles;

                if ((r == nrows - 1) && (c == ncols - 1))
                    return nsteps; // destination reached

                // examine next possible move
                for (int [] move : moves)
                {
                    Visit next = null;
                    int   x    = r + move[0]; // next row
                    int   y    = c + move[1]; // next column

                    if (x < 0 || x == nrows ||
                        y < 0 || y == ncols)
                        continue;

                    next = new Visit(x, y, o);
                    if (grid[x][y] == 1)
                        next.obstacles++;
                    if (next.obstacles <= k && !seen.contains(next))
                    {   // not visited and within allowed limit
                        seen.add(next);
                        Q.offer(next);
                    }
                }
            }
            ++nsteps;
        }
        return  -1;
    }
}