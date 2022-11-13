/*
250. Count Univalue Subtrees

Given the root of a binary tree, return the number of uni-value subtrees.

A uni-value subtree means all nodes of the subtree have the same value.

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
    public int countUnivalSubtrees(TreeNode root) 
    {
        int [] count = new int[1];

        isUnival(root, count);
        return count[0];
    }
    
    private boolean isUnival(TreeNode node, int[] count)
    {
        boolean same = true;

        if (node == null)
            return false; // null tree
        else if (node.left == null && node.right == null)
        {
            count[0]++;
            return true; // leaf
        }
        
        // go to left
        if (node.left != null)
            same =  isUnival(node.left, count) &&
                    (node.left.val == node.val);
        // go to right
        if (node.right != null)
            same =  isUnival(node.right, count) && same &&
                    (node.right.val == node.val);
    
        if (same)
            ++count[0];
        return same;
    }
}
