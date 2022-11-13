/*
1368. Minimum Cost to Make at Least One Valid Path in a Grid

Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:

1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some signs on the cells of the grid that point outside the grid.

You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.

*/

class Visit
{
    int  row;
    int  col;
    int  cost;
    
    public Visit(int row, int col, int cost)
    {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}

class Solution 
{
    public int minCost(int[][] grid) 
    {
        int           nrows   = grid.length;
        int           ncols   = grid[0].length;
        boolean[][]   visited = new boolean[nrows][ncols];
        Queue<Visit>  Q;
        int[][]       moves   = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
    
        // 1: right, 2: left, 3: down, 4: up 
        
        // priority Q based on cost to reach the cell
        Q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        
        // start with [0, 0]
        Q.offer(new Visit(0, 0, 0));
        
        while (!Q.isEmpty())
        {
            Visit  v    = Q.poll();
            int    r    = v.row;
            int    c    = v.col;
            int    cost = v.cost;
            int    sign = grid[r][c];
            
            // check if destination is reached
            if (r == nrows - 1 && c == ncols - 1)
                return cost;
        
            visited[r][c] = true;
            
            // examine next possible moves
            for (int i = 0; i < 4; ++i)
            {
                Visit  next = null; // next possible visit
                int [] move = moves[i];
                int    x = r + move[0];
                int    y = c + move[1];
                int    newCost = cost;
            
                // skip if out of bounds or visited cell
                if (x < 0 || x == nrows || y < 0 || y == ncols ||
                    visited[x][y])
                    continue;
            
                // (i + 1) is also the expected direction
                // if not the same, cost increases by 1
                if (grid[r][c] != (i + 1))
                    newCost++;
                
                next = new Visit(x, y, newCost);
                Q.offer(next);
            }
        }
        return 0;
    }
}
