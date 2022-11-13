/*
149. Max Points on a Line

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

*/

class Solution 
{
    public int maxPoints(int[][] points) 
    {
        Map<Double, Integer> slope = new HashMap<>();
        
        int maxP = 0;
        for (int i = 0; i < points.length; ++i)
        {
            for (int j = i + 1; j < points.length; ++j)
            {
                double m;
                int [] p1 = points[i];
                int [] p2 = points[j];
            
                if (p2[0] == p1[0])
                    m = Double.POSITIVE_INFINITY;
                else
                    m = ((double)p2[1] - p1[1]) / ((double)p2[0] - p1[0]);

                if (m == -0d)
                    m = 0.0;
                
                slope.put(m, 1 + slope.getOrDefault(m, 0));
                maxP = Math.max(maxP, slope.get(m));
            }
            slope.clear();
        }
        return maxP + 1;
    }
}
