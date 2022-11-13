/*
1192. Critical Connections in a Network

There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

*/

class Solution
{
    int  order     = 0;
    public List<List<Integer>> criticalConnections(int n,
                                                   List<List<Integer>> conn)
    {
        List<List<Integer>> critical = new ArrayList<>();
        List<Integer> []    graph    = new List[n];
        int           []    visited  = new int[n];
        // 0: not visited, > 0 : visited with rank

        // create an access friendly graph
        for (List<Integer> c : conn)
        {
            int u = c.get(0);
            int v = c.get(1);

            if (graph[u] == null)
                graph[u] = new ArrayList<Integer>();
            if (graph[v] == null)
                graph[v] = new ArrayList<Integer>();

            graph[u].add(v);
            graph[v].add(u);
        }

        traverse(graph, 0, -1, visited, critical);
        return critical;
    }

    private int traverse(List<Integer>[] graph, int node, int parent,
                         int[] visited, List<List<Integer>> critical)
    {
        if (visited[node] > 0)
            return visited[node];

        visited[node] = ++order; // update the order

        int visit = Integer.MAX_VALUE;

        // traverse all child nodes
        if (graph[node] != null)
            for (int child : graph[node])
                if (child != parent)
                {
                    int childVisit = traverse(graph, child, node,
                                              visited, critical);

                    visit = Math.min(visit, childVisit);
                }

        // if no cycle found, then parent -- node is a critical edge
        if (visit >= visited[node] && parent != -1)
            critical.add(Arrays.asList(parent, node));

        return Math.min(visited[node], visit); // min visit id for this node
    }
}