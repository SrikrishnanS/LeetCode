/*
463. Island Perimeter

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

*/

class Solution
{
    public int islandPerimeter(int[][] grid)
    {
        int nrow = grid.length;
        int ncol = grid[0].length;
        int i, j;
        int len = 0;

        for (i = 0; i < nrow; ++i)
        {
            for (j = 0; j < ncol; ++j)
            {
                if (grid[i][j] == 0)
                    continue; // skip water

                if (i == 0 || (grid[i-1][j] == 0))
                    ++len;
                if (i == nrow - 1 || (grid[i+1][j] == 0))
                    ++len;
                if (j == 0 || (grid[i][j-1] == 0))
                    ++len;
                if (j == ncol - 1 || (grid[i][j+1] == 0))
                    ++len;
            }
        }
        return len;
    }
}