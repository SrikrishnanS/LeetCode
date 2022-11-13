/* 261. Graph Valid Tree

You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.
 */

class Solution
{
    public boolean validTree(int n, int[][] edges)
    {
        List<Integer>[] graph = new List[n];
        Set<Integer> visited = new HashSet<Integer>();

        if (edges.length != n - 1)
            return false;

        for (int [] e : edges)
        {
            int u = e[0];
            int v = e[1];

            if (graph[u] == null)
                graph[u] = new ArrayList<Integer>();
            if (graph[v] == null)
                graph[v] = new ArrayList<Integer>();

            graph[u].add(v);
            graph[v].add(u);
        }

        visit(graph, 0, visited); // start dfs from node 0

        return visited.size() == n;
    }

    private void visit(List<Integer>[] graph, int node,
                       Set<Integer> visited)
    {
        List<Integer> children = graph[node];

        visited.add(node);

        if (children != null)
            for (int child : children)
                if (!visited.contains(child))
                    visit(graph, child, visited);
    }
}