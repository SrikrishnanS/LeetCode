/*
1971. Find if Path Exists in Graph

There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

*/

class Solution 
{
    public boolean validPath(int n, int[][] edges,
                             int source, int destination) 
    {
        List<Integer>[] graph = new List[n];
        
        // create an access friendly graph
        for (int [] e : edges)
        {
            // there is a path from e[0] to e[1]
            List<Integer> L1  = graph[e[0]];
            List<Integer> L2  = graph[e[1]];
            
            if (L1 == null)
                L1 = graph[e[0]] = new ArrayList<Integer>();
            if (L2 == null)
                L2 = graph[e[1]] = new ArrayList<Integer>();

            L1.add(e[1]);
            L2.add(e[0]);
        }
        return isConnected(graph, source, destination, new boolean[n]);
    }
    
    private boolean isConnected(List<Integer>[] graph,
                                int source, int destination,
                                boolean[] visited)
    {
        List<Integer> children = null;
        if (visited[source])
            return false;
        else if (source == destination)
            return true;
        
        visited[source] = true; // mark node as visited
        children = graph[source];
        
        if (children != null)
            for (int next : children)
                if (isConnected(graph, next, destination, visited))
                    return true;
    
        return false; // no path from source -> destination
    }
}
