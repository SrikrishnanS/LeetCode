/* 1376. Time Needed to Inform All Employees

A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.
 */
class Solution 
{
    public int numOfMinutes(int n, int headID, int[] manager,
                            int[] informTime) 
    {
        List<List<Integer>> reportees = new ArrayList<List<Integer>>();
        Queue<int[]>        Q;
        int                 maxTime   = 0;
        
        for (int i = 0; i < n; ++i)
            reportees.add(new ArrayList<Integer>());
        
        for (int m = 0; m < manager.length; ++m)
        {
            if (manager[m] == -1)
                continue;
            List <Integer> list = reportees.get(manager[m]);
            list.add(m); // m reports to manager[m]
        }
    
        Q = new LinkedList<int[]>();
        Q.offer(new int[]{headID, 0});
        // empid, time pair
    
        while (!Q.isEmpty())
        {
            int []        e = Q.poll();
            List<Integer> reps = reportees.get(e[0]);

            for (int j = 0; j < reps.size(); ++j)
            {
                int time = e[1] + informTime[e[0]];
                maxTime = Math.max(maxTime, time);
                if (reportees.get(reps.get(j)).size() > 0)
                    Q.offer(new int[]{reps.get(j), time});
            }
        }
        return maxTime;
    }
}
