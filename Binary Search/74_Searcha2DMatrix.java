/*
74. Search a 2D Matrix

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m*n - 1;
        int p;
        
        while (l <= r)
        {
            p = (r-l)/2 + l;
            
            if (matrix[p / n][p % n] == target)
                return true;
            else if (matrix[p / n][p % n] < target)
                l = p + 1;
            else
                r = p - 1;
        }
        return false;
    }
}
