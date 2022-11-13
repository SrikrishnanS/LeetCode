/* 766. Toeplitz Matrix

Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 */
class Solution 
{
    public boolean isToeplitzMatrix(int[][] matrix) 
    {
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                if (!isToeplitz(matrix, i, j, matrix[i][j], visited))
                    return false;
        return true;
    }

    private boolean isToeplitz(int[][] matrix, int r, int  c, int val,
                               boolean [][] visited)
    {
        if (r < 0 || r == matrix.length ||
            c < 0 || c == matrix[0].length ||
            visited[r][c])
            return true;
       
        visited[r][c] = true;        
        if (matrix[r][c] != val)
            return false;
    
        return isToeplitz(matrix, r + 1, c + 1, val, visited);
    }
}
