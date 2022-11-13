/* 1462. Course Schedule IV

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.

For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.
 */
class Solution 
{
    
    public List<Boolean> checkIfPrerequisite(int N,
                                             int[][] prerequisites,
                                             int[][] queries) 
    {
        List<Integer>[] graph = new List[N];
        Boolean [] visited = new Boolean[N];
        Map<Integer, Set<Integer>> order;
        List<Boolean> answers = new ArrayList<Boolean>();
    
        order = new HashMap<>(); // course -> set of descendant children
        
        // create an access-friendly  graph
        for (int [] pair : prerequisites)
        {
            // p[0] is the parent for p[1]
            if (graph[pair[0]] == null)
                graph[pair[0]] = new ArrayList<>();
            graph[pair[0]].add(pair[1]);
        }
    
        for (int i = 0; i < N; ++i)
            if (!examineCourses(graph, i, visited, order))
                return null;
        
        // find answer for each of the queries
        // check if q[0] has q[1] as its descendant 
        for (int [] q : queries)            
            answers.add(order.get(q[0]).contains(q[1]));
        
        return answers;
    }
    
    private boolean examineCourses(List<Integer> [] graph, int parent,
                                   Boolean [] visited,
                                   Map<Integer, Set<Integer>> order)
    {
        List<Integer> children;

        if (visited[parent] != null)
            return !visited[parent]; // already visited
    
        visited[parent] = true;
        children = graph[parent];
        
        if (!order.containsKey(parent))
            order.put(parent, new HashSet<Integer>());        
        
        if (children != null)
        {
            order.get(parent).addAll(children);
            for (int child : children)
            {
                if (!examineCourses(graph, child, visited, order))
                    return false; // had a cycle, so return

                order.get(parent).addAll(order.get(child));
            }
        }
        visited[parent] = false;
        return true;
    }
}
