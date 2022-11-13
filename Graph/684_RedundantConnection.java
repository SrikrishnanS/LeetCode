/*
684. Redundant Connection

In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

*/

class Solution 
{
    public int[] findRedundantConnection(int[][] edges) 
    {
        List<Integer>[] graph = new ArrayList[edges.length + 1];
        boolean[] visited;

        for (int [] edge : edges)
        {      
            visited = new boolean[edges.length + 1];
            if (hasCycle(graph, edge[0], edge[1], visited))
                return edge;
            
            // add edge to graph if no cycle is introduced
            if (graph[edge[0]] == null)
                graph[edge[0]] = new ArrayList<Integer>();
            if (graph[edge[1]] == null)
                graph[edge[1]] = new ArrayList<Integer>();

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return null;
    }
    
    private boolean hasCycle(List<Integer>[] graph, int u, int v,
                             boolean[] visited)
    {
        if (visited[u])
            return false;
        
        visited[u] = true;
        if (u == v)
            return true;
        
        if (graph[u] != null)
            for (int next : graph[u])
                if (hasCycle(graph, next, v, visited))
                    return true;
        
        return false;
    }
    
}
