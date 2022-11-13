/* 572. Subtree of Another Tree

subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node''s descendants. The tree tree could also be considered as a subtree of itself.
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
    private void traverse(TreeNode node, StringBuilder sb)
    {
        if (node == null)
        {
            sb.append("#");
            return;
        }
        
        sb.append("|" + node.val);
        traverse(node.left, sb);
        sb.append("|");
        traverse(node.right, sb);
        sb.append("|");
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        StringBuilder  rootStr = new StringBuilder();
        StringBuilder  subRootStr = new StringBuilder();
        
        traverse(root, rootStr);
        traverse(subRoot, subRootStr);

        return rootStr.toString().contains(subRootStr);
    
    }
}
