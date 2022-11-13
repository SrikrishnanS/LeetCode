/*
814. Binary Tree Pruning

Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

A subtree of a node node is node plus every node that is a descendant of node.

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
    public TreeNode pruneTree(TreeNode root) 
    {
         return prune(root);   
    }
    
    private boolean isLeaf(TreeNode node)
    {
        return (node.left == null) && (node.right == null);
    }
    
    private TreeNode prune(TreeNode node)
    {
        if (node == null)
            return null;
        
        node.left = prune(node.left);
        node.right = prune(node.right);
        
        if (node.val == 0 && isLeaf(node))
            node = null;

        return node;
    }
    
}
