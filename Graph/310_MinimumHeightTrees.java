/*
310. Minimum Height Trees

A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

*/

class Solution
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges)
    {
        Set<Integer>[] graph = new Set[n];
        Queue<Integer> Q     = new LinkedList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        int []  degree       = new int[n];

        // if less than 3 nodes, return the nodes as result
        if (n < 3)
        {
            for (int i = 0; i < n; ++i)
                result.add(i);
            return result;
        }

        // create an access friendly graph out of the tree
        for (int [] e : edges)
        {
            int u = e[0];
            int v = e[1];

            if (graph[u] == null)
                graph[u] = new HashSet<Integer>();
            if (graph[v] == null)
                graph[v] = new HashSet<Integer>();

            graph[u].add(v);
            graph[v].add(u);
        }

        // add all child nodes to the Q to begin with
        for (int i = 0; i < n; ++i)
        {
            degree[i] = graph[i].size();
            if (degree[i] == 1)
                Q.offer(i);
        }

        while (!Q.isEmpty())
        {
            int qSize = Q.size();

            result.clear(); // clear previously added ones
            while (qSize-- > 0)
            {
                int node = Q.poll();

                result.add(node); // a possible candidate

                //  add any neighbor that becomes a leaf
                for (int child : graph[node])
                    if (--degree[child] == 1)
                        Q.offer(child);
            }
        }
        return result;
    }
}
