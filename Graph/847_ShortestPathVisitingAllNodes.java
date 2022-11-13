/* 847. Shortest Path Visiting All Nodes

You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 */
class Solution 
{
    // shortest path covering all vertices
    public int shortestPathLength(int[][] graph) 
    {
        int         nrows = graph.length; // number of nodes in the graph
        int         ncols = (int)Math.pow(2, nrows);
        int         VISITED_ALL = ncols - 1; // bit pattern if all nodes visited
        boolean[][] visited; // is node in this order visited?
        Queue<Pair<Integer, Integer>>  Q;
        int         pathLength = 0;   
        
        visited = new boolean[nrows][ncols];
        Q = new LinkedList<Pair<Integer, Integer>>();
        for (int i = 0; i < nrows; ++i)
        {
            int order = (1 << i);
            visited[i][order] = true; // mark noode with the pattern as visited
            Q.offer(new Pair(i, order)); // start BFS with all nodes initially
        }

        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            for (int i = 0; i < qSize; ++i) // process ith batch
            {
                Pair<Integer, Integer> p = Q.poll();
                int node = p.getKey(); // node being examined
                int order = p.getValue(); // order in which this node was visited
                
                if (order == VISITED_ALL)
                    return pathLength; // return path len if all nodes visited
            
                for (int child : graph[node])
                {
                    int newOrder = order | (1 << child);
                    
                    if (!visited[child][newOrder])
                    {
                        visited[child][newOrder] = true;
                        Q.offer(new Pair<Integer, Integer>(child, newOrder));
                    }
                }
            }
            ++pathLength;
        }
        return 0; // graph not connected
    }
}
