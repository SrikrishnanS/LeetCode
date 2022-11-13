/* 802. Find Eventual Safe States

There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node.

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 */
class Solution
{
    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        List<Integer> list = new ArrayList<Integer>();
        int           N = graph.length;
        Boolean []    visited = new Boolean[N];
        boolean []    checked = new boolean[N];

        for (int i = 0; i < N; ++i)
            if (isSafeNode(graph, i, visited, checked))
                list.add(i);
        return list;
    }
    private boolean isSafeNode(int[][] graph, int n, Boolean []visited,
                               boolean[] checked)
    {
        if (visited[n] != null)
            return !visited[n];
        else if (checked[n])
            return true;
        
        visited[n] = true;
        for (int state: graph[n])
            if (!isSafeNode(graph, state, visited, checked))
                return false;
        
        visited[n] = false;
        checked[n] = true;
        return true;
    }
}
