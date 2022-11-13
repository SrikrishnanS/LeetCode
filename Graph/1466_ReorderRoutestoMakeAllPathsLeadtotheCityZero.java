/* 1466. Reorder Routes to Make All Paths Lead to the City Zero

There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.
 */
class Solution 
{
    int count;
    public int minReorder(int n, int[][] connections) 
    { 
        List<int[]>[] graph = new List[n];
        boolean[] visited   = new boolean[n];
        
        for (int[] edge : connections)
        {
            // there is a path from v1 to v2
            int v1 = edge[0];
            int v2 = edge[1];
            
            if (graph[v1] == null)
                graph[v1] = new ArrayList<int[]>();
            if (graph[v2] == null)
                graph[v2] = new ArrayList<int[]>();
            
            graph[v1].add(new int[]{v2, 1});  // out edge
            graph[v2].add(new int[]{v1, -1}); // in edge
        }
        inspect(0, graph, visited);
        return this.count;
    }
    
    private void inspect(int n, List<int[]>[] graph, boolean[] visited)
    {
        visited[n] = true;
        for (int[] pair : graph[n])
        {
            int node = pair[0];
            int dir  = pair[1];
            
            if (!visited[node])
            {
                if (dir > 0)
                    ++count;
                inspect(node, graph, visited);
            }
        }
    }
}
