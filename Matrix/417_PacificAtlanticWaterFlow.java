/* 417. Pacific Atlantic Water Flow

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
class Solution 
{
    int nrows, ncols;
    boolean[][]pVisited; // pacific
    boolean[][]aVisited; // atlantic
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        List<List<Integer>> list = null;
        nrows = heights.length;
        ncols = heights[0].length;
    
        list = new ArrayList<List<Integer>>();
        pVisited = new boolean[nrows][ncols];
        aVisited = new boolean[nrows][ncols];
        for (int i = 0; i < nrows; ++i)
        {
            flood(heights, -1, i, 0, pVisited); // flood ith row for pacific
            flood(heights, -1, i, ncols - 1, aVisited); // flood ith row for atlantic
        }
        
        for (int j = 0; j < ncols; ++j)
        {
            flood(heights, -1, 0, j, pVisited); // flood jth col for pacific
            flood(heights, -1, nrows - 1, j, aVisited); // flood jth col for atlantic
        }
       
        // add cell to list
        for (int i = 0; i < nrows; ++i)
            for (int j = 0; j < ncols; ++j)
                if (pVisited[i][j] && aVisited[i][j])
                    list.add(Arrays.asList(new Integer[]{i, j}));
        return list;
    }

    private void flood(int [][] heights, int val, int r, int c, boolean[][] visited)
    {
        if (r < 0 || r == nrows ||
            c < 0 || c == ncols ||
            visited[r][c] || heights[r][c] < val)
            return;
        
        visited[r][c] = true; // mark this cell as visited
        // flood neighboring cells
        flood(heights, heights[r][c], r + 1, c, visited);
        flood(heights, heights[r][c], r - 1, c, visited);
        flood(heights, heights[r][c], r, c + 1, visited);
        flood(heights, heights[r][c], r, c - 1, visited);
    }
}
