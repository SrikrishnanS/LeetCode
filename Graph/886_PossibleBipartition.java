/* 886. Possible Bipartition

We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 */
class Solution 
{
    public boolean possibleBipartition(int n, int[][] dislikes) 
    {
        List<Integer>[] graph = new List[n + 1];
        int [] visited = new int[n + 1];

        // create a graph
        for (int [] pair : dislikes)
        {
            if (graph[pair[0]] == null)
                graph[pair[0]] = new ArrayList<Integer>();
            if (graph[pair[1]] == null)
                graph[pair[1]] = new ArrayList<Integer>();
            
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }
        
        // check if groupable
        for (int i = 1; i <= n; i++)
            if (visited[i] == 0 && !isGroupable(graph, i, 1, visited))
                return false;
        return true;
    }
    
    private boolean isGroupable(List<Integer>[] graph, int n, 
                                int group, int[] visited)
    {
        List<Integer> next;
        if (visited[n] != 0)
            return visited[n] == group;
    
        visited[n] = group;
        next = graph[n];
        if (next != null)
            for (int i : next)
                if (!isGroupable(graph, i, -group, visited))
                    return false;
        return true;
    }
}