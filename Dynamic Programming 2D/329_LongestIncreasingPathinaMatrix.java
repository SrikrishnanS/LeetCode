/* 329. Longest Increasing Path in a Matrix

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 */
class Solution
{
    private int[][] moves = new int[][]{{-1, 0},{0, -1},{0, 1},{1, 0}};
    public int longestIncreasingPath(int[][] matrix)
    {
        int     nrows   = matrix.length;
        int     ncols   = matrix[0].length;
        int[][] pathLen = new int[nrows][ncols];
        int     i, j;
        int     maxLen  = 0;

        for (i = 0; i < nrows; ++i)
            for (j = 0; j < ncols; ++j)
                maxLen = Math.max(maxLen, getPathLength(matrix, pathLen, i, j));

        return maxLen;
    }

    private int getPathLength(int[][] matrix, int [][]pathLen, int i, int j)
    {
        int     nrows   = matrix.length;
        int     ncols   = matrix[0].length;
        if (pathLen[i][j] != 0)
            return pathLen[i][j];

        for (int[]move : moves)
        {
            int r = i + move[0];
            int c = j + move[1];

            if (r >= 0 && r < nrows &&
                c >= 0 && c < ncols &&
                matrix[i][j] < matrix[r][c])
                pathLen[i][j] = Math.max(pathLen[i][j],
                                         getPathLength(matrix, pathLen, r, c));
        }
        ++pathLen[i][j]; // atleast 1
        return pathLen[i][j];
    }
}
