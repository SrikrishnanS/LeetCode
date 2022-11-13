/* 1129. Shortest Path with Alternating Colors

You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

You are given two arrays redEdges and blueEdges where:

redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.
 */
class Solution 
{
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges)
    {
        final int RED            = 0;
        final int BLUE           = 1;
        List<Integer> [] reds       = new List[n];
        List<Integer> [] blues      = new List[n];
        Queue<int[]>     Q;
        int[]            result     = new int[n];
        int              pathLength = 0;
        boolean [][]     visited    = new boolean[n][2];
        
        for (int i = 0 ; i < n; ++i)
        {
            reds[i] = new ArrayList<Integer>();
            blues[i] = new ArrayList<Integer>();
        }
        
        for (int[] edge: redEdges)
            reds[edge[0]].add(edge[1]);

        for (int[] edge: blueEdges)
            blues[edge[0]].add(edge[1]);

        Arrays.fill(result, -1); // default value if not path to a node
        Q = new LinkedList<int[]>();
        
        Q.offer(new int[]{0, RED});
        Q.offer(new int[]{0, BLUE});
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            for (int i = 0; i < qSize; ++i)
            {
                int[] pair  = Q.poll();
                int   node  = pair[0];
                int   color = pair[1];

                // We found a path from 0 --...--> node
                // Assign the pathLength
                if (result[node] == -1)
                    result[node] = pathLength;
                else
                    result[node] = Math.min(result[node], pathLength);
                
                // Choose the alternate color now
                if (color == BLUE)
                {
                    for (int v : reds[node])
                        if (!visited[v][RED])
                            Q.offer(new int[]{v, RED});
                }
                else
                {
                    for (int v : blues[node])
                       if (!visited[v][BLUE])
                           Q.offer(new int[]{v, BLUE});
                }
                visited[node][color] = true;
            }
            ++pathLength;
        }
        return result;
    }
}
