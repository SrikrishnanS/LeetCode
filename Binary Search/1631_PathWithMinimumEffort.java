/*
1631. Path With Minimum Effort

You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

*/

class Solution 
{
    public int minimumEffortPath(int[][] heights) 
    {
        int l = 0, r = 1000000;

        while (l < r)
        {
            int m = l + ((r - l)/2);
        
            if (hasPath(heights, 0, 0, m,
                        new boolean[heights.length][heights[0].length]))
                r = m;    
            else
                l = m + 1;
        }    
        return l;
    }
    
    private int [][] moves = new int[][]{{-1, 0},{0, -1},{1, 0},{0, 1}};
    
    private boolean hasPath(int [][]heights, int r, int c, int diff,
                            boolean [][] visited)
    {
        int nrows = heights.length;
        int ncols = heights[0].length;

        if (r == nrows - 1 && c == ncols - 1)
            return true; // destination reached
        
        visited[r][c] = true;
        for (int [] move : moves)
        {
            int x = r + move[0];
            int y = c + move[1];
            
            if (x < 0 || x == nrows || y < 0 || y == ncols || visited[x][y] ||
                Math.abs(heights[x][y] - heights[r][c]) > diff)
                continue;
            else if (hasPath(heights, x, y, diff, visited))
                return true;
        }
        return false;
    }
}
