/*
539. Minimum Time Difference

Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

*/

class Solution 
{
    public int findMinDifference(List<String> timePoints) 
    {
        List<Integer>  points   = new ArrayList<Integer>();
        int            minDiff  = 0;
        int            totMinutes, prev;
    
        for (String s : timePoints)
        {
            String [] str = s.split(":");
        
            int hour = Integer.valueOf(str[0]);
            int min = Integer.valueOf(str[1]);
            
            totMinutes = hour * 60 + min;
            points.add(totMinutes);
        }
    
        Collections.sort(points);
        minDiff = Integer.MAX_VALUE;
        prev = points.get(0);
        for (int i = 1; i < points.size(); ++i)
        {
            int curr = points.get(i);
            minDiff = Math.min(minDiff, curr - prev);
            prev = curr;
        }
        // diff between last and first
        minDiff = Math.min(minDiff,
                           (24 * 60) - points.get(points.size() - 1) +
                           points.get(0));
        return minDiff;
    }
}
