/*
1740. Find Distance in a Binary Tree

Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.

The distance between two nodes is the number of edges on the path from one to the other.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    private void buildGraph(TreeNode node, TreeNode parent,
                            Map<Integer, Set<Integer>> graph)
    {
        Set<Integer> neighbors = null;

        if (node == null)
            return;

        graph.putIfAbsent(node.val, new HashSet<Integer>());
        neighbors = graph.get(node.val);

        if (parent != null)
            neighbors.add(parent.val);
        if (node.left != null)
            neighbors.add(node.left.val);
        if (node.right != null)
            neighbors.add(node.right.val);

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }

    public int findDistance(TreeNode root, int source, int destination)
    {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        Queue<Integer> Q = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        int          distance = 0;

        // build an access friendly graph
        buildGraph(root, null, graph);

        if (!graph.containsKey(source) || !graph.containsKey(destination))
            return -1; // node values not present in the tree

        // start with source
        visited.add(source);
        Q.offer(source);

        while (!Q.isEmpty())
        {
            int qSize = Q.size();

            while ((qSize--) > 0)
            {
                int node = Q.poll();

                if (node == destination)
                    return distance;

                for (int child : graph.get(node))
                    if (!visited.contains(child))
                    {
                        visited.add(child);
                        Q.offer(child);
                    }
            }
            ++distance;
        }
        return -1;
    }
}
