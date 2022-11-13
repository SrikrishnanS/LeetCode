/* 1654. Minimum Jumps to Reach Home

A certain bug's home is on the x-axis at position x. Help them get there from position 0.

The bug jumps according to the following rules:

It can jump exactly a positions forward (to the right).
It can jump exactly b positions backward (to the left).
It cannot jump backward twice in a row.
It cannot jump to any forbidden positions.
The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.

Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.
 */
class Solution
{
    public int minimumJumps(int[] forbidden, int a, int b, int x)
    {
        Set<String> visited   = new HashSet<String>();
        Queue<int[]> Q        = new LinkedList<int[]>();
        int          jumps    = 0;
        int          farthest = x + a + b; // see leetcode! :-)

        // mark forbidden positions as visited
        for (int pos : forbidden)
        {
            visited.add(pos + ":-1");
            visited.add(pos + ":1");
            farthest = Math.max(farthest, pos + a + b); // see leetcode :-)
        }
        
        // start with position 0 and move forward initially
        // Q has <position, direction(+1/-1)> pair
        Q.offer(new int[]{0, 1});
        visited.add(0 + ":1");

        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            for (int i = 0; i < qSize; ++i)
            {
                int []pair = Q.poll();
                int   pos  = pair[0];
                int   dir  = pair[1];
                int forward = pos + a;
                int backward = pos - b;
      
                if (pos == x)
                    return jumps;
            
                // can jump forward a positions from here in any case
                if ((forward <= farthest) &&
                    !visited.contains(forward + ":1"))
                {
                    visited.add(forward + ":" + dir);
                    Q.offer(new int[]{forward, 1});
                }
                // can jump backward only if current jump was forward
                if ((dir > 0) && (backward >= 0) &&
                    !visited.contains(backward + ":-1"))
                {
                    visited.contains(backward + ":-1");
                    Q.offer(new int[]{backward, -1});
                }
            }
            ++jumps;
        }
        return -1;
    }
}
