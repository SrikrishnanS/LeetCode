/* 48. Rotate Image

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */

class Solution {
    public void rotate(int[][] matrix) {
        int nrow   = matrix.length;
        int ncol   = matrix[0].length;
        int i, j;

        for (i = 0; i < nrow; ++i)
        {
            for (j = i+1; j < nrow; ++j)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int n = 0; n < nrow; ++n)
        {
            for (i = 0, j = ncol -1; i < j; ++i, --j)
            {
                int temp = matrix[n][i];
                matrix[n][i] = matrix[n][j];
                matrix[n][j] = temp;
            }
        }
    }
}
