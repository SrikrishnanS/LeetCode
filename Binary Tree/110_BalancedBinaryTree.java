/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

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
    public boolean isBalanced(TreeNode root) 
    {
        return isHeightBalanced(root)[1] == 1;
    }
    
    // [0] : height, [1] : isBalanced
    private  int[] isHeightBalanced(TreeNode node)
    {
        if (node == null)
            return new int[]{0, 1};
        
        int[] left = isHeightBalanced(node.left);
        if (left[1] != 1)
            return new int[]{-1, 0};
    
        int[] right = isHeightBalanced(node.right);
        if (right[1]  != 1)
            return new int[] {-1 , 0};
        
        int height = 1 + Math.max(left[0], right[0]);
        int balance = (Math.abs(left[0] - right[0]) <= 1) ? 1 : 0;
    
        return new int[]{height, balance};
    }
    
}
