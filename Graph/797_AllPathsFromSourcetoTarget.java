/* 797. All Paths From Source to Target

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
class Solution
{
    public List<List<Integer>> allPathsSourceTarget(int[][] graph)
    {
        List<List<Integer>> P = new ArrayList<List<Integer>>();
        Stack<Integer> S = new Stack<Integer>();
        
        S.push(0); // start with node 0
        traverse(graph, 0, S, P);
        return P;
    }
    
    private void traverse(int [][]graph, int n,
                          Stack<Integer> S, List<List<Integer>> P)
    {
        if (n == graph.length - 1) // last node reached
        {
            P.add(new ArrayList<Integer>(S)); // add current stack to list
            return;
        }
        for (int e : graph[n])
        {
            S.push(e);
            traverse(graph, e, S, P);
            S.pop();
        }
    }
}
