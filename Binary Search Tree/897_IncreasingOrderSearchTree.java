/*
897. Increasing Order Search Tree

Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

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
    private TreeNode end;

    public TreeNode increasingBST(TreeNode node)
    {
        TreeNode head = new TreeNode();

        end = head;
        traverse(node);
        return head.right;
    }
    public void traverse(TreeNode node)
    {
        if (node == null)
            return;

        traverse(node.left);

        node.left = null;
        end.right = node;
        end = node;

        traverse(node.right);
    }
}
