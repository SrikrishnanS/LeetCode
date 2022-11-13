/*
815. Bus Routes

You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.

Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

*/

class Solution
{
    private void buildRoutes(int[][] routes, Set<Integer>[] stops,
                             int source, int target,
                             Set<Integer> start, Set<Integer> end)
    {
        // track all the stops in each route
        for (int i = 0; i < routes.length; ++i)
        {
            stops[i] = new HashSet<Integer>();

            for (int r : routes[i])
                stops[i].add(r);

            if (stops[i].contains(source))
                start.add(i); // ith route is one potential start route
            if (stops[i].contains(target))
                end.add(i); // ith route is one potential end route
        }
    }

    private boolean hasIntersection(Set<Integer> A, Set<Integer> B)
    {
        Iterator<Integer> it = A.iterator();

        while (it.hasNext())
            if (B.contains(it.next()))
                return true;

        return false;
    }

    private Set<Integer>[] buildGraph(Set<Integer>[] stops)
    {
        int            n     = stops.length;
        Set<Integer>[] graph = new Set[n]; // graph for route nodes

        for (int i = 0; i < stops.length; ++i)
        {
            Set<Integer> A = stops[i];
            for (int j = i + 1; j < stops.length; ++j)
            {
                Set<Integer> B = stops[j];
                // is there a path from route i to j?
                if (hasIntersection(A, B))
                {
                    if (graph[i] == null)
                        graph[i] = new HashSet<Integer>();
                    if (graph[j] == null)
                        graph[j] = new HashSet<Integer>();

                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        return graph;
    }

    private int getShortestDistance(Set<Integer>[] graph,
                                    Set<Integer> start, Set<Integer> end)
    {
        int            distance =  1; // atleast one bus even within same route
        Queue<Integer> Q        =  new LinkedList<Integer>();
        Set<Integer>   visited  =  new HashSet<Integer>();

        for (int source: start)
        {
            visited.add(source);
            Q.offer(source);
        }

        while (!Q.isEmpty())
        {
            int    qSize = Q.size();
            while ((qSize--) > 0)
            {
                int node = Q.poll(); // current node
                Set<Integer> children = graph[node];

                if (end.contains(node))
                    return distance; // target reached

                if (children != null)
                    for (int c : children)
                        if (!visited.contains(c))
                        {
                            Q.offer(c);
                            visited.add(c);
                        }
            }
            ++distance;
        }
        return -1;
    }

    public int numBusesToDestination(int[][] routes, int source, int target)
    {
        int            n     = routes.length;
        Set<Integer>[] stops = new Set[n]; // tracks stops in each route
        Set<Integer>[] graph;
        Set<Integer> start, end;

        if (source == target)
            return 0;

        start = new HashSet<Integer>();
        end = new HashSet<Integer>();
        buildRoutes(routes, stops, source, target, start, end);

        graph = buildGraph(stops);

        return getShortestDistance(graph, start, end);
    }
}