/*
270. Closest Binary Search Tree Value

Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.

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
    private void closestValue(TreeNode node, double target, Double[] min)
    {
        if (node == null)
            return;
    
        double diff = Math.abs(target - node.val);
        
        if (diff < min[0])
        {
            min[0] = diff;
            min[1] = (double)node.val;
        }
        if (node.val < target)
            closestValue(node.right, target, min);
        else
            closestValue(node.left, target, min);
    }

    public int closestValue(TreeNode root, double target) 
    {
        Double [] min = new Double[2];
        min[0] = Double.MAX_VALUE; // minimum diff
        min[1] = null; // closest value
        closestValue(root, target, min);
        return (int)(double)min[1];
    }
}
