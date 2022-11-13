/* 547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
 */
class Solution
{
    public int findCircleNum(int[][] isConnected)
    {
        int        ncities = isConnected.length;
        boolean[]  visited = new boolean[ncities];
        int        nprovinces = 0;
        
        for (int n = 0; n < ncities; ++n)
            if (!visited[n])
            {
                visitCity(isConnected, n, visited);
                ++nprovinces;
            }
        return nprovinces;
    }

    private void visitCity(int[][] graph, int n, boolean[] visited)
    {        
        visited[n] = true;
        for (int i = 0; i < graph[n].length; ++i)
            if (graph[n][i] == 1 && !visited[i])
                visitCity(graph, i, visited);
    }
}
