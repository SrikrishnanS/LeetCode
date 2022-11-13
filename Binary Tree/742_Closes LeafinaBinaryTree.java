/*
742. Closest Leaf in a Binary Tree

Given the root of a binary tree where every node has a unique value and a target integer k, return the value of the nearest leaf node to the target k in the tree.

Nearest to a leaf means the least number of edges traveled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

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
    private void traverse(TreeNode node, Map<Integer, Integer[]> graph)
    {
        if (node == null)
            return;
    
        graph.putIfAbsent(node.val, new Integer[3]);
        if (node.left != null)
        {
            graph.get(node.val)[1] = node.left.val; // left child neighbor
            graph.putIfAbsent(node.left.val, new Integer[3]);
            graph.get(node.left.val)[0] = node.val; // parent neighbor
            traverse(node.left, graph);
        }
        if (node.right != null)
        {        
            graph.get(node.val)[2] = node.right.val; // right child neighbor
            graph.putIfAbsent(node.right.val, new Integer[3]);
            graph.get(node.right.val)[0] = node.val; // parent neighbor
            traverse(node.right, graph);
        }
    }

    public int findClosestLeaf(TreeNode root, int k) 
    {
        Queue<Integer>          Q        = new LinkedList<>();
        Map<Integer, Integer[]> graph    = new HashMap<>();
        Set<Integer>            visited  = new HashSet<>();
        // node -> neighbors:[parent, left, right]
        // leaf has left == right == null
        
        // create an access friendly graph
        traverse(root, graph);
    
        Q.offer(k); // start  with kth node
        visited.add(k);
        
        while (!Q.isEmpty())
        {
            int       n        = Q.poll();
            Integer[] children = graph.get(n);
            
            // check if leaf node has been reached
            if (children[1] == null && children[2] == null)
                return n; // return first leaf node value reached
        
            for (Integer child : children)
                if (child != null && !visited.contains(child))
                {
                    Q.offer(child);
                    visited.add(child);
                }
        }
        return 0;
    }
}
