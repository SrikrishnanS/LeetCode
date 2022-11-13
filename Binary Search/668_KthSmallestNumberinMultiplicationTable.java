/*
668. Kth Smallest Number in Multiplication Table

Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).

Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

*/

class Solution
{
    public int findKthNumber(int m, int n, int k)
    {
        // answer lies somewhere between 1  and (m * n)
        int  l = 1;
        int  r = (m * n);

        // so perform binary search to find
        // condition is count of numbers >= k
        // find lower bound
        while (l < r)
        {
            int mid = l + ((r - l)/2);

            if (getCount(m, n, mid) >= k)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int getCount (int m, int n, int target)
    {
        int count = 0;
        // how many numbers in row m are < mid
        for (int i = 1; i <= m; ++i)
            count += Math.min((target / i), n);

        return count;
    }

}
