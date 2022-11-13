/* 542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][]        result;
        int            nrows = mat.length;
        int            ncols = mat[0].length;
        int            r, c;
        Queue<int[]>   Q;
        boolean [][]   visited;
        int[][]        moves;
        int            nsteps;

        visited  = new boolean[nrows][ncols];
        moves    = new int[][] {{-1, 0},{1,0},{0,-1},{0,1}};
        result   = new int[nrows][ncols];
        Q        = new LinkedList<int[]>();        

        // Add the 0 cells to the Q initially
        for (int i = 0; i < nrows; ++i)
            for (int j = 0; j < ncols; ++j)
                if (mat[i][j] == 0)
                {
                    visited[i][j] = true;
                    Q.offer(new int[]{i, j});
                    result[i][j] = 0;
                }

        nsteps = 1;
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            for (int i = 0; i < qSize; ++i) // process this batch
            {
                int[] cell = Q.poll();
                
                for (int[] move: moves)
                {
                    r = cell[0] + move[0];
                    c = cell[1] + move[1];
                    
                    if (r < 0 || r == nrows ||
                        c < 0 || c == ncols ||
                        visited[r][c])
                        continue;
                    
                    visited[r][c] = true;
                    Q.offer(new int[]{r, c});
                    result[r][c] = nsteps;
                }
            }
            ++nsteps;
        }
        return result;
    }
}
