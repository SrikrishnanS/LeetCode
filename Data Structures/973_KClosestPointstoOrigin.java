/*
973. K Closest Points to Origin

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

*/

class Solution 
{
    public int[][] kClosest(int[][] points, int k) 
    {
        int [][] result = new int[k][2];
        
        Queue<int[]>  Q = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
         // [0]: distance, [1] : index
        
        for (int i = 0; i < points.length; ++i)
        {
            int [] p = points[i];
            int d = (p[0] * p[0]) + (p[1] * p[1]);
            
            Q.add(new int[]{d, i});
            
            if (Q.size() > k)
                Q.poll();            
        }
        
        // fill up the output array
        for (int i = 0; i < k; ++i)
        {
            int [] entry = Q.poll();
            int    idx   = entry[1];
        
            result[k - i - 1] = points[idx];
        }
        return result;
    }
}