/* 1325. Delete Leaves With a Given Value

Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you cannot).
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
    private  boolean isLeafNode(TreeNode node)
    {
        return (node.left == null) && (node.right == null);
    }
    
    public TreeNode removeLeafNodes(TreeNode node, int target) 
    {
        if (node == null)
            return null;

        node.left = removeLeafNodes(node.left, target);
        node.right = removeLeafNodes(node.right, target);
    
        if (isLeafNode(node) && node.val == target)
            node = null;

        return node;
    }
}
