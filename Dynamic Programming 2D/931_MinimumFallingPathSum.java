/*
931. Minimum Falling Path Sum

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

*/

class Solution 
{
    public int minFallingPathSum(int[][] matrix) 
    {
        int  nrows  = matrix.length;
        int  ncols  = matrix[0].length;
        int  minPathSum = Integer.MAX_VALUE;
    
        for (int i = 1; i < nrows; ++i)
        {
            for (int j = 0; j < ncols; ++j)
            {
                Integer a = null, b = null, c = null;
                int     rowMin;
                
                if (j < ncols - 1)
                    a = matrix[i-1][j+1];
                
                rowMin = b =  matrix[i-1][j];
                
                if (j > 0)
                    c = matrix[i-1][j-1];
             
                if (a != null)
                    rowMin = Math.min(rowMin, a);
                if (c != null)
                    rowMin = Math.min(rowMin, c);
            
                matrix[i][j] += rowMin;
            }
        }
        
        for (int j = 0; j < ncols; ++j)
            minPathSum = Math.min(minPathSum, matrix[nrows - 1][j]);
    
        return minPathSum;
    }
}
