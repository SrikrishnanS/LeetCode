/* 286. Walls and Gates

You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 */
class Solution 
{
    public void wallsAndGates(int[][] rooms) 
    {
        final int WALL_CELL  = -1;
        final int GATE_CELL  = 0;
        final int EMPTY_CELL = Integer.MAX_VALUE;
        int       nrows      = rooms.length;
        int       ncols      = rooms[0].length;
        int       nsteps     = 1;
        Queue<int[]> Q       = new LinkedList<int[]>();
        int   [][]moves;
        
        moves = new int[][]{{-1, 0},{0, 1},{0, -1},{1, 0}};
        
        // first add all gate cells to the Q
        for (int i = 0; i < nrows; ++i)
            for (int j = 0; j < ncols; ++j)
                if (rooms[i][j] == GATE_CELL)
                    Q.offer(new int[]{i, j});        
        
        // find all empty cells nearest gate
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            while ((qSize--) > 0)
            {
                int[] cell = Q.poll();
                
                for (int[] move : moves)
                {
                    int row = cell[0] + move[0];
                    int col = cell[1] + move[1];
                
                    // skip wall, gate and already visited cells
                    if (row < 0 || row == nrows ||
                        col < 0 || col == ncols ||
                        rooms[row][col] == WALL_CELL ||
                        rooms[row][col] == GATE_CELL ||
                        rooms[row][col] < EMPTY_CELL)
                        continue;
                
                    rooms[row][col] = nsteps;
                    Q.offer(new int[]{row, col});
                }
            }
            ++nsteps;
        }
    }
}
