/*
938. Range Sum of BST

Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

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
    public int rangeSumBST(TreeNode node, int low, int high) 
    {
        int sum = 0;
    
        if (node == null)
            return sum;
  
        if (node.val >= low && node.val <= high)
            sum += node.val;        
        if (low < node.val)
            sum += rangeSumBST(node.left, low, high);
        if (high > node.val)
            sum += rangeSumBST(node.right, low, high);        
 
        return sum;
    }
}
