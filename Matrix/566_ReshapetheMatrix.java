/* 566. Reshape the Matrix

You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) 
    {
        int[][] result = new int[r][c];    
        int done       = 0;
        int i, j;
        
        if (mat.length * mat[0].length != r*c)
            return mat;
            
        for (i = 0; i < mat.length; ++i)
        {
            for (j = 0; j < mat[0].length; ++j)
            {
                int val = mat[i][j];
                int m, n;
                
                m = done / (c);
                n = done % (c);
                
                result[m][n] = val;                
                ++done;
            }
        }
        return result;
    }
}
