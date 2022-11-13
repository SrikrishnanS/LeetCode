/* 1319. Number of Operations to Make Network Connected

There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 */
class Solution 
{
    public int makeConnected(int n, int[][] connections)
    {
        int       networks = 0;
        int       ncables  = connections.length;
        boolean[] visited  = new boolean[n];
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        if (ncables < n - 1)
            return -1; // not enough cables

        // set up adjacency matrix using array lists
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        // record adjacent nodes in the graph
        for (int[] pair : connections)
        {
            int x = pair[0];
            int y = pair[1];
        
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        // broadcast message to all connected nodes
        for (int i = 0; i < n; ++i)
            if (!visited[i])
            {
                broadcast(graph, i, visited);
                ++networks;
            }
        return networks - 1;
    }

    private void broadcast(List<List<Integer>> graph,
                           int n, boolean[] visited)
    {
        List<Integer> adjacent = graph.get(n);
        
        visited[n] = true;
        for (int i = 0; i < adjacent.size(); ++i)
        {
            int node = adjacent.get(i);
            if (!visited[node])
                broadcast(graph, node, visited);
        }
    }    
}
