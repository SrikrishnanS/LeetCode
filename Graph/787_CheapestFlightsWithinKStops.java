/*
787. Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

*/

class Solution 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, 
                                 int k) 
    {
        Map<Integer, Integer> [] graph = new Map[n];
        Queue<int[]> Q = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        Integer[] visited = new Integer[n];
        
        // [0]: price, [1]: node, [2]: stops
        
        // create an access friendly map
        for (int [] f : flights)
        {
            if (graph[f[0]] == null)
                graph[f[0]] = new HashMap<Integer, Integer>();
            
            graph[f[0]].put(f[1], f[2]);
        }
        
        Q.offer(new int[] {0, src, 0});
        
        while (!Q.isEmpty())
        {
            int [] values = Q.poll();
            
            int price = values[0];
            int city  = values[1];
            int cities = values[2];
            
            if (city == dest)
                return price;
            
            if (visited[city] == null)
                visited[city] = cities; // number of cities seen so far
            
            // more cities allowed
            if (cities <= k)
            {
                // next possible city  stops
                Map<Integer, Integer> next = graph[city];

                if (next != null)
                    for (int c : next.keySet())
                        if (visited[c] == null || visited[c] > cities)
                            Q.offer(new int[] {price + next.get(c), c, cities + 1});
            }
        }
        return - 1;
    }
}
