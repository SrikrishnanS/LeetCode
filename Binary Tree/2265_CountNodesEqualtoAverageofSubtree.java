/*
2265. Count Nodes Equal to Average of Subtree

Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

Note:

The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.

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
    public int averageOfSubtree(TreeNode root) 
    {
        return getAverage(root)[2];
    }
    
    // returns {sum, total, count} triplet
    private int[] getAverage(TreeNode node)
    {
        if (node == null)
            return new int[]{0, 0, 0};
        
        int [] left  = getAverage(node.left);
        int [] right = getAverage(node.right);
        
        int sum   = node.val + left[0] + right[0];
        int total = 1 + left[1] + right[1];
        int count = left[2] + right[2];

        if (node.val == (int) (sum / total))
            ++count;

        return new int[]{sum, total, count};
    }
}
