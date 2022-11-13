/* 253. Meeting Rooms II

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 */
class Solution 
{
    public int minMeetingRooms(int[][] intervals) 
    {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);    
    
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for (int[] slot : intervals)
        {
            if (!Q.isEmpty() && Q.peek()[1] <= slot[0])
                Q.poll();
            Q.offer(slot);
        }
        return Q.size();
    }
}
