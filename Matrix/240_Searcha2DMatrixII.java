/*
240. Search a 2D Matrix II

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

*/

class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int i = 0, j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0)
        {
            if (matrix[i][j] < target)
                ++i;
            else if (matrix[i][j] > target)
                --j;
            else
                return true;
        }
        return false;
    }
}
