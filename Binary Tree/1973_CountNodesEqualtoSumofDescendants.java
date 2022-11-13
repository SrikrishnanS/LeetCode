/*
1973. Count Nodes Equal to Sum of Descendants

Given the root of a binary tree, return the number of nodes where the value of the node is equal to the sum of the values of its descendants.

A descendant of a node x is any node that is on the path from node x to some leaf node. The sum is considered to be 0 if the node has no descendants.

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
    private int findSum(TreeNode node, int[] count)
    {
        if (node == null)
            return 0;
    
        int sum = findSum(node.left, count) +
                  findSum(node.right, count);
    
        if (node.val == sum)
            ++count[0];
        
        sum += node.val;
        return sum;
    }
    
    public int equalToDescendants(TreeNode root) 
    {
        int [] count  = new int[1];
        
        findSum(root, count);
        return count[0];
    }
}
