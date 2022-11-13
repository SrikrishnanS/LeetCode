/* 210. Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
class Solution
{
    int end;
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        int[]   orderArr = new int[numCourses];
        List<Integer>[] prereq = new List[numCourses];
        Boolean []      visited = new Boolean[numCourses];
        
        end = numCourses;
        for (int[] pair : prerequisites)
        {
            int parent = pair[1];
            int child = pair[0];
            
            if (prereq[parent] == null)
                prereq[parent] = new ArrayList<Integer>();
            prereq[parent].add(child);
        }
        
        for (int course = 0; course < numCourses; ++course)
            if (!canTake(prereq, course, visited, orderArr))
                return new int[]{};

        return orderArr;
    }
    
    private boolean canTake(List<Integer>[] prereq, int n, Boolean[] visited,
                            int[] orderArr)
    {
        List<Integer> children = prereq[n];
        
        if (visited[n] != null)
            return !visited[n];
        
        visited[n] = true;
        if (children != null)
            for (int course: children)
                if (!canTake(prereq, course, visited, orderArr))
                    return false;
        orderArr[--end] = n;
        visited[n] = false;
        return true;
    }
}
