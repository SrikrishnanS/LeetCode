/*
1245. Tree Diameter

The diameter of a tree is the number of edges in the longest path in that tree.

There is an undirected tree of n nodes labeled from 0 to n - 1. You are given a 2D array edges where edges.length == n - 1 and edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the tree.

Return the diameter of the tree.

*/

class Solution
{
    private int diameter = 0;
    public int treeDiameter(int[][] edges)
    {
        int              n  = edges.length + 1;
        List<Integer>[]  G  = new List[n];

        // create an access friendly graph
        for (int [] e : edges)
        {
            int u = e[0];
            int v = e[1];
            if (G[u] == null)
                G[u] = new ArrayList<Integer>();
            if (G[v] == null)
                G[v] = new ArrayList<Integer>();

            G[u].add(v);
            G[v].add(u);
        }

        graphDiameter(G, 0, -1);
        return diameter;
    }

    // return max ending at node
    private int graphDiameter(List<Integer>[]  G, int node, int parent)
    {
        int distance = 0;
        List<Integer> children = G[node];
        int max1 = 0, max2 = 0;

        if (children != null)
            for (int c : children)
            {
                if (c == parent)
                    continue;
                int d = graphDiameter(G, c, node);

                // pick the top two deep ones
                if (d > max1)
                {
                    max2 = max1;
                    max1 = d;
                }
                else if (d > max2)
                {
                    max2 = d;
                }
            }
        diameter = Math.max(diameter, max1 + max2);
        return 1 + max1;
    }
}
