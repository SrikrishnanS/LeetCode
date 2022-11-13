/* 543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
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
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        diameter(root);
        return this.diameter;
    }
    
    private int diameter(TreeNode node)
    {
        if (node == null)
            return 0;
    
        int left = diameter(node.left);
        int right = diameter(node.right);
    
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right); // include current node
    }
}
