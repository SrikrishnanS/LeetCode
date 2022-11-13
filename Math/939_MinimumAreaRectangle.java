/* 939. Minimum Area Rectangle

You are given an array of points in the X-Y plane points where points[i] = [xi, yi].

Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes. If there is not any such rectangle, return 0.
 */
class Solution 
{
    public int minAreaRect(int[][] points) 
    {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        int minArea = Integer.MAX_VALUE;
        for (int[] point : points)
        {
            if (!map.containsKey(point[0]))
                map.put(point[0], new HashSet<Integer>());
            map.get(point[0]).add(point[1]);
        }
        
        for (int i = 0; i < points.length; ++i)
        {
            for (int j = i+1; j < points.length; ++j)
            {
                int [] p1 = points[i];
                int [] p2 = points[j];
                
                if (p1[0] == p2[0] || p1[1] == p2[1])
                    continue;
                if (map.get(p1[0]).contains(p2[1]) &&
                    map.get(p2[0]).contains(p1[1]))
                    minArea = Math.min(minArea, 
                                       Math.abs(p1[0] - p2[0]) *
                                       Math.abs(p1[1] - p2[1]));
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}