/*
687. Longest Univalue Path

Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.

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
    private int maxLen;
    
    private int getLongestPath(TreeNode node)
    {
        if (node == null)
            return 0;
    
        int left = getLongestPath(node.left);
        int right = getLongestPath(node.right);
        
        int leftLen = 0, rightLen = 0;
        
        if (node.left != null && node.val == node.left.val)
            leftLen = left + 1;
        if (node.right != null && node.val == node.right.val)    
            rightLen = right + 1;
    
        maxLen = Math.max(maxLen, leftLen + rightLen); // global maxima
        return Math.max(leftLen, rightLen); // local maxima, can't be both
    }
    
    public int longestUnivaluePath(TreeNode root)
    {
        this.maxLen = 0;
        getLongestPath(root);
        return this.maxLen;
    }
}