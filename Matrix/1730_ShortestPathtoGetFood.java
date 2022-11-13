/* 1730. Shortest Path to Get Food

You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.

You are given an m x n character matrix, grid, of these different types of cells:

'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.
 */
class Solution
{
    public int getFood(char[][] grid)
    {
        Queue<int[]> Q = new LinkedList<int[]>();
        int nrows = grid.length;
        int ncols = grid[0].length;
        boolean [][]visited = new boolean[nrows][ncols];
        int nsteps = -1;
        int [][]moves = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
        int r, c;

        // find the starting location
        for (int i = 0; i < nrows; ++i)
        {
            if (nsteps == 0)
                break;
            for (int j = 0; j < ncols; ++j)
                if (grid[i][j] == '*')
                {
                    visited[i][j] = true;
                    Q.offer(new int[]{i, j});
                    nsteps = 0;
                    break;
                }
        }
    
        if (nsteps < 0)
            return nsteps;

        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            for (int i = 0; i < qSize; ++i) // process next batch
            {
                int[] cell = Q.poll();
                for (int[] move: moves)
                {
                    r = move[0] + cell[0];
                    c = move[1] + cell[1];
                    
                    if (r < 0 || r == nrows ||
                        c < 0 || c == ncols ||
                        visited[r][c])
                        continue;
                    
                    if (grid[r][c] == '#')
                        return nsteps + 1;
                    else if (grid[r][c] != 'O')
                        continue;
                    // found an empty unvisited cell!
                    Q.offer(new int[]{r, c}); // add to Q
                    visited[r][c] = true;
                } 
            }
            ++nsteps;
        }
        return -1;
    }
}
