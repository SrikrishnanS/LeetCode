/*
114. Flatten Binary Tree to Linked List

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

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
    private TreeNode flattenNode(TreeNode node)
    {
        if (node == null ||
            (node.left == null && node.right == null))
            return node;    
        
        TreeNode left = flattenNode(node.left);
        TreeNode right = flattenNode(node.right);
     
        if (left != null)
        {
            left.right = node.right;
            node.right = node.left;
            node.left =  null;
        }
        return right != null ? right : left;
    }
    
    public void flatten(TreeNode node) 
    {
        flattenNode(node);
    }
}
