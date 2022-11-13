/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

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
    public int minDepth(TreeNode root) 
    {
        Queue<TreeNode> Q  = new LinkedList<>();
        int             height = 1;
        
        if (root != null)
            Q.offer(root);
        while (!Q.isEmpty())
        {
            int qSize = Q.size();
            
            while ((qSize--) > 0)
            {
                TreeNode  node  = Q.poll();
                
                if (node.left == null && node.right == null)
                    return height;
                
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
            }
            ++height;
        }
        return 0;
    }
}
