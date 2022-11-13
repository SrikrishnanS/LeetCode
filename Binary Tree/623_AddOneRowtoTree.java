/*
623. Add One Row to Tree

Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) 
    {
        Queue<TreeNode> Q;
        int             level = 1;

        if (depth == 1)
        {
            TreeNode node = new TreeNode(val, root, null);
            return node;
        }
        
        Q = new LinkedList<TreeNode>();
        Q.offer(root);
        
        while (!Q.isEmpty() && level < depth - 1)
        {
            int qSize = Q.size();
            
            while ((qSize--) > 0)
            {
                TreeNode node = Q.poll();
                
                if (node.left != null)
                    Q.offer(node.left);
                if (node.right != null)
                    Q.offer(node.right);
            }
            ++level;
        }
        
        while (!Q.isEmpty())
        {
            TreeNode node = Q.poll();
            
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }
}