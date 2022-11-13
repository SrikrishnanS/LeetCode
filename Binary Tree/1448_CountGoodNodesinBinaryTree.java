/*
1448. Count Good Nodes in Binary Tree

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

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
    private void goodNodes(TreeNode node, int maxVal, int[] count)
    {
        if (node == null)
            return;
    
        if (node.val >= maxVal)
        {
            maxVal = node.val;
            ++count[0];
        }
        goodNodes(node.left, maxVal, count);
        goodNodes(node.right, maxVal, count);
    }
    
    public int goodNodes(TreeNode root) 
    {
        int[] count = new int[1];

        goodNodes(root, Integer.MIN_VALUE, count);
        return count[0];
    }
}
