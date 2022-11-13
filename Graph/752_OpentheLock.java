/* 752. Open the Lock

You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
class Solution
{
    public int openLock(String[] deadends, String target)
    {
        Set<String> visited = new HashSet<String>();
        Queue<String> Q = new LinkedList<String>();
        int attempts = 0;
        
        for (String s : deadends)
            visited.add(s);
        
        if (!visited.contains("0000"))
        {
            visited.add("0000");
            Q.offer("0000");
        }
          
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            for (int i = 0; i < qSize; ++i)
            {
                String s = Q.poll();
                            
                if (s.equals(target))
                    return attempts;

                for (String next: getNextTurns(s))
                    if (!visited.contains(next))
                    {
                        visited.add(next);
                        Q.offer(next);   
                    }
            }
            ++attempts;
        }
        return -1;
    }
    
    private String[] getNextTurns(String s)
    {
        String[] chances = new String[8];
        char[] sarr = s.toCharArray();
        int count = -1;
        
        for (int i = 0; i < 4; i ++)
        {
            char old = sarr[i];
            
            sarr[i] = (char) old == '9' ? '0' : (char)(old + (char)1); // next number
            chances[++count] = new String(sarr);
            sarr[i] = (char) old == '0' ? '9' : (char)(old - (char)1); // previous number
            chances[++count] = new String(sarr);
            sarr[i] = old;
        }
        return chances;
    }
}
