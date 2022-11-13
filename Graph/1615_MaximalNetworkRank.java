/* 1615. Maximal Network Rank

There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.

The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 */
class Solution 
{
    public int maximalNetworkRank(int n, int[][] roads) 
    {
        boolean[][]edges = new boolean[n][n];
        int [] degree    = new int[n];
        int maxRank      = 0;
    
        for (int [] r : roads)
            {
                edges[r[0]][r[1]] = true;
                edges[r[1]][r[0]] = true;
                ++degree[r[0]];
                ++degree[r[1]];
            }
    
        for (int i = 0; i < n; ++i)
            for (int j = i+1; j < n; ++j)
            {
                int rank = degree[i] + degree[j];
                if (edges[i][j])
                    --rank;
                maxRank = Math.max(maxRank, rank);
            }
        return maxRank;
    }
}
