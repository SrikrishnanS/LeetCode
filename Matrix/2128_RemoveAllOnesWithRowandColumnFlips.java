/*
2128. Remove All Ones With Row and Column Flips

You are given an m x n binary matrix grid.

In one operation, you can choose any row or column and flip each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

Return true if it is possible to remove all 1's from grid using any number of operations or false otherwise.

*/

class Solution
{
    private boolean isFlippable(int[] a, int [] b, int n)
    {
        int num = 0;

        for (int i = 0; i < n; ++i)
            num += a[i] ^ b[i];

        // all must be same, or all different
        return (num == 0) || (num == n);
    }

    public boolean removeOnes(int[][] grid)
    {
        // check if subsequent rows match the 0th row patter
        // or its flipped version
        for (int i = 1; i < grid.length; ++i)
            if (!isFlippable(grid[0], grid[i], grid[0].length))
                return false;

        return true;
    }
}
