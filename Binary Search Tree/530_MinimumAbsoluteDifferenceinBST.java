/*
530. Minimum Absolute Difference in BST

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

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
    private void traverse(TreeNode node, TreeNode[] prev, int [] diff)
    {
        if (node == null)    
            return;

        traverse(node.left, prev, diff);

        if (prev[0] != null)
            diff[0] = Math.min(diff[0], Math.abs(node.val - prev[0].val));

        prev[0] = node;
        traverse(node.right, prev, diff);
    }
    
    public int getMinimumDifference(TreeNode root) 
    {
        TreeNode [] prev = new TreeNode[1];
        int      [] diff = new int[]{Integer.MAX_VALUE};

        traverse(root, prev, diff);
        return diff[0];
    }
}
