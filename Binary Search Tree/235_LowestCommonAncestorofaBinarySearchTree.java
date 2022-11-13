/*
235. Lowest Common Ancestor of a Binary Search Tree


Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution 
{
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) 
    {
        if (node == null || p == null || q == null)
            return null;

        if (node.val == p.val || node.val == q.val)
            return node;
        
        if ((node.val > p.val && node.val < q.val) ||
            (node.val > q.val && node.val < p.val))
            return node;
        else if (node.val > p.val && node.val > q.val)
            return lowestCommonAncestor(node.left, p, q);
        else if (node.val < p.val && node.val < q.val)
            return lowestCommonAncestor(node.right, p, q);
        else
            return null;
    }
}
