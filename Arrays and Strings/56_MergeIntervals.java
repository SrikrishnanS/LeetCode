/*
56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

*/

class Solution 
{
    
    private boolean isOverlapping(int lastEnd, int []j)
    {
        return (j[0] <= lastEnd);
    }
    
    public int[][] merge(int[][] intervals) 
    {
        List<int[]> l = new ArrayList<int[]>();
        int[][] results;
        int row;
        int lastEnd;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        lastEnd = intervals[0][1];
        l.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int next = 1; next < intervals.length; ++next)
        {
            int [] i = l.get(l.size()-1);
            int [] j = intervals[next];
            
            if (isOverlapping(lastEnd, j))
            {
                l.remove(l.size()-1);
                l.add(new int[]{i[0], Math.max(i[1], j[1])});
                lastEnd = Math.max(i[1], j[1]);
            }
            else
            {
                l.add(new int[]{j[0], j[1]});
                lastEnd = j[1];
            }
        }
        results = new int[l.size()][2];
        row = 0;
        for (int [] interval : l)
        {
            results[row][0] = interval[0];
            results[row][1] = interval[1];
            ++row;
        }
        return results;
    }
}
