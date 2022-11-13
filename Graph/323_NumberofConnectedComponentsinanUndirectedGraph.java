/* 323. Number of Connected Components in an Undirected Graph

You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph. */

// Using DFS:

class Solution 
{
    public int countComponents(int n, int[][] edges)
    {
        List[]      G          = new List[n];
        boolean []  visited    = new boolean[n];
        int         components = 0;
        
        for (int i = 0; i < n; ++i)
            G[i] = new ArrayList<Integer>();
        
        for (int[] edge: edges)
        {
            int v1 = edge[0];
            int v2 = edge[1];
            
            // there's an edge between V1 and V2
            G[v1].add(v2);
            G[v2].add(v1);
        }
        
        for (int i = 0; i < n; ++i)
            if (!visited[i])
            {
                visit(G, i, visited);
                ++components;
            }
        return components;
    }

    private void visit(List<Integer>[] G, int n, boolean[] visited)
    {
        List<Integer> V = G[n];
        
        visited[n] = true;
        for (int v : V)
            if (!visited[v])
                visit(G, v, visited);
    }
}

// Using Union-find:

class Solution
{
    public int countComponents(int n, int[][] edges)
    {
        int[] parent    = new int[n];
        int components  = n;

        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] edge : edges)
        {
            int p1 = findParent(parent, edge[0]);
            int p2 = findParent(parent, edge[1]);
            if (p1 != p2)
            {
                parent[p2] = p1;
                components--;
            }
        }
        return components;
    }
    
    private int findParent(int[] parent, int i)
    {
        if (i == parent[i])
            return i;

        parent[i] = findParent(parent, parent[i]);
        return  parent[i];
    }
}
