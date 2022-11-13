/*
1727. Largest Submatrix With Rearrangements

You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.

Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.

*/

class Solution
{
    public int largestSubmatrix(int[][] matrix)
    {
        int maxArea = 0;
        // first mark the number of continuous 1s in each column
        for (int i = 1; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                if (matrix[i][j] == 1)
                    matrix[i][j] += matrix[i - 1][j];

        // sort each row desc. and find max possible area
        for (int i = 0; i < matrix.length; ++i)
        {
            int [] row = matrix[i];

            Arrays.sort(row);
            reverse(row);

            for (int j = 0; j < row.length; ++j)
                maxArea = Math.max(maxArea, row[j] * (j + 1));
        }
        return maxArea;
    }
    private void reverse(int [] arr)
    {
        for (int i = 0, j = arr.length - 1; i < j; ++i, --j)
        {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}