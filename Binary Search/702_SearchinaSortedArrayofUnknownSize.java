/*
702. Search in a Sorted Array of Unknown Size

This is an interactive problem.

You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:

returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.

Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

You must write an algorithm with O(log n) runtime complexity.

*/

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution 
{
    public int search(ArrayReader reader, int target) 
    {
        int l = 0, r = 1;
        
        // get a feasible solution boundary
        while (reader.get(r) < target)
        {
            l = r;
            r *= 2;
        }
        
        // perform binary search
        while (l <= r)
        {
            int m = l + ((r - l) / 2);
        
            if (reader.get(m) == target)
                return m;
            else if (reader.get(m) < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}
