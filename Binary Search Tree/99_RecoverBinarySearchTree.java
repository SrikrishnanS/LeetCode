/*
99. Recover Binary Search Tree

You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

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
    private void traverse(TreeNode node, TreeNode[] past)
    {
        if (node == null)
            return;
    
        traverse(node.left, past);
        
        if (past[1] == null && node.val < past[0].val)
            past[1] = past[0];
        if (past[1] != null && node.val < past[0].val)
            past[2] = node;
            
        past[0] = node; // last seen node
        
        traverse(node.right, past);
    }
    
    public void recoverTree(TreeNode root) 
    {
        TreeNode[] past = new TreeNode[3]; // 1, 2 null initially
        
        past[0] = new TreeNode(Integer.MIN_VALUE);
        // 0: previous, 1: first node to swap, 2: second node to swap
        
        traverse(root, past);
        
        // swap past[1] and past[2]
        int temp = past[1].val;
        past[1].val = past[2].val;
        past[2].val = temp;        
    }
}
