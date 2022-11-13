/*
1059. All Paths from Source Lead to Destination

Given the edges of a directed graph where edges[i] = [ai, bi] indicates there is an edge between nodes ai and bi, and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually, end at destination, that is:

At least one path exists from the source node to the destination node
If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
The number of possible paths from source to destination is a finite number.
Return true if and only if all roads from source lead to destination.

*/

class Solution
{
    public boolean leadsToDestination(int n, int[][] edges,
                                      int source, int destination)
    {
        Set<Integer>[]  G  = new Set[n];
        Set<Integer> start = null;

        // create an access friendly graph
        for (int [] e : edges)
        {
            int u = e[0];
            int v = e[1];
            // there's a path from u -> v

            if (G[u] == null)
                G[u] = new HashSet<Integer>();

            G[u].add(v);
        }

        // is there a path from every child of source to destination?
        return hasPath(G, source, destination, new Boolean[n]);
    }

    private boolean hasPath(Set<Integer>[] G, int source, int destination,
                            Boolean[] checked)
    {
        if (G[source] == null)
            return (source == destination);
        else if (checked[source] != null) // has been seen before
            return checked[source]; // better be true

        checked[source] = false; // mark this node as false (processing)

        // is there a path from every child of source to destination?
        for (int node : G[source])
            if (!hasPath(G, node, destination, checked))
                return false;

        checked[source] = true; // mark this node as true (processed)
        return true;
    }
}
