/*
1315. Sum of Nodes with Even-Valued Grandparent

Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

A grandparent of a node is the parent of its parent if it exists.

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
    public int sumEvenGrandparent(TreeNode root) 
    {
        int               sum  = 0;
        Queue<TreeNode[]> Q    = new LinkedList<>();
        
        // [0] -> node, [1] -> parent, [2], grandparent
        if (root != null)
            Q.offer(new TreeNode[]{root, null, null});
        
        while (!Q.isEmpty())
        {
            TreeNode[] nodes  = Q.poll();
            TreeNode   node   = nodes[0];
            TreeNode   parent = nodes[1];
            TreeNode   grandp = nodes[2];
            
            if (grandp != null && (grandp.val % 2 == 0))
                sum += node.val;
            if (node.left != null)
                Q.offer(new TreeNode[]{node.left, node, parent});
            if (node.right != null)
                Q.offer(new TreeNode[]{node.right, node, parent});
        }
        return sum;
    }
}
