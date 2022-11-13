/* 1557. Minimum Number of Vertices to Reach All Nodes

Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.

Find the smallest set of vertices from which all nodes in the graph are reachable. It is guaranteed that a unique solution exists.

Notice that you can return the vertices in any order.
 */
class Solution 
{
    public List<Integer> findSmallestSetOfVertices(int n,
                                                   List<List<Integer>> edges) 
    {
        List<Integer> set       = new ArrayList<Integer>();  
        boolean[]     reachable = new boolean[n];
        
        for (List<Integer> pair : edges)
            reachable[pair.get(1)] = true;

        for (int i = 0; i < n; ++i)
            if (!reachable[i])
                set.add(i);
        return set;
    }
}
