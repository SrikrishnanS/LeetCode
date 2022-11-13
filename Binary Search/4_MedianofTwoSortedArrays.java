/*
4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

*/

class Solution 
{
    public double findMedianSortedArrays(int[] X, int[] Y)
    {
        int x = X.length;
        int y  = Y.length;
        
        if (x > y)
            return findMedianSortedArrays(Y, X);
    
        int l = 0;
        int r = x;
        
        while (l <= r)
        {
            int nx = (l + r) / 2;            // no. of elems in X
            int ny = (x + y + 1) / 2 - nx;   // no. of elems in Y
            
            int maxLeftX   = (nx == 0) ? Integer.MIN_VALUE : X[nx - 1];
            int maxLeftY   = (ny == 0) ? Integer.MIN_VALUE : Y[ny - 1];
            
            int minRightX  = (nx == x) ? Integer.MAX_VALUE : X[nx];
            int minRightY  = (ny == y) ? Integer.MAX_VALUE : Y[ny];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) // found
            {
                if ((x + y) % 2 == 0)
                    return (double)(Math.max(maxLeftX, maxLeftY) +
                                    Math.min(minRightX, minRightY)) / 2;
                else
                    return (double)Math.max(maxLeftX, maxLeftY);
            }
            else if (maxLeftX > minRightY)
                r = nx - 1;
            else
                l = nx + 1;
            
        }
        return Double.NaN;
    }
}
