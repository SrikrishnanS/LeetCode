/*
124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node''s values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root)
    {
        getMaxPathSum(root);
        return maxSum;
    }
    private int getMaxPathSum(TreeNode node)
    {
        int leftSum, rightSum;
        if (node == null)
            return 0;

        leftSum = Math.max(0, getMaxPathSum(node.left));
        rightSum = Math.max(0, getMaxPathSum(node.right));
        maxSum = Math.max(maxSum, leftSum + node.val + rightSum);
        return node.val + Math.max(leftSum, rightSum); //can't be both
    }   
}
