/* 1091. Shortest Path in Binary Matrix

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
 */
class Solution 
{
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int           nrows  = grid.length;
        int           ncols  = grid[0].length;
        Queue <int[]> Q      = new LinkedList<int[]>();
        int[][]       moves;
        int           r = 0, c = 0, d = 1;
        
        
        moves = new int[][]{{-1, -1}, {-1, 0}, {-1, 1},{0, -1},
                            {0, 1}  , {1, -1}, {1, 0}, {1, 1}};
    
        if (grid[0][0] == 1 || grid[nrows - 1][ncols - 1] == 1)
            return -1;
     
        grid[0][0] = d;
        Q.offer(new int[]{r, c, d});
        while (!Q.isEmpty())
        {
            int [] cell = Q.poll();
        
            for (int [] move: moves)
            {
                r = cell[0] + move[0];
                c = cell[1] + move[1];
                d = cell[2]; // distance for this cell

                if (r < 0 || r == nrows ||
                    c < 0 || c == ncols ||
                    grid[r][c] != 0)
                    continue;
                grid[r][c] = d + 1;
                Q.offer(new int[]{r, c, d + 1});
            }
        }
        d = grid[nrows - 1][ncols - 1];
        return d == 0 ? -1: d;
    }
}
