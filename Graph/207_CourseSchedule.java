/* 207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
 */
class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        Boolean[]       opted  = new Boolean[numCourses];
        boolean[]       hasFinished  = new boolean[numCourses];
        List<Integer>[] prereq = new List[numCourses];
    
        // opted-> null: not visited yet, true -> opted, false -> not opted
        
        // create an access friendly map
        // maps parent -> child
        for (int[] pair : prerequisites)
        {
            int parent = pair[1];
            int child = pair[0];
            
            if (prereq[parent] == null)
                prereq[parent] = new ArrayList<Integer>(); // create it the first time
            
            prereq[parent].add(child);
        }
        
        // check if each course can be finished
        for (int course = 0; course < numCourses; ++course)
            if (!canFinish(prereq, course, opted, hasFinished))
                return false;
        return true;
    }

    private boolean canFinish(List<Integer>[] prereq, int n, Boolean[] opted,
                              boolean[] hasFinished)
    {
        List<Integer> children = prereq[n];
        
        if (opted[n] != null)
            return  !opted[n];
        else if (hasFinished[n])
            return true;
        
        opted[n] = true;   // visited and taken
        if (children != null)
            for (int course: children)
                if (!canFinish(prereq, course, opted, hasFinished))
                    return false;
        opted[n] = false;  // visited and free to take now
        hasFinished[n] = true; 
        return true;
    }
}
