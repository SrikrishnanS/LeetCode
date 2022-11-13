/*
378. Kth Smallest Element in a Sorted Matrix

Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

*/

class Solution 
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        int          n = matrix.length; // n x n matrix
        Queue<int[]> Q = new PriorityQueue<int[]>((a, b)->a[0] - b[0]);
        // [0]: value, [1]: row, [2]: column
        
        for (int i = 0; i < Math.min(n, k); ++i)
            Q.offer(new int[]{matrix[i][0], i, 0});

        int [] value = null;
        
        for (int i = 0; i < k; ++i)
        {
            value = Q.poll(); // top value is popped
            
            int r = value[1];
            int c = value[2];
     
            if (c < n - 1) // take value from same row
                Q.offer(new int[]{matrix[r][c + 1], r, c + 1});
        }
        return value[0];
    }
}
