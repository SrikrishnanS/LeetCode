/*
450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.

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
    private boolean isLeafNode(TreeNode node)
    {
        return (node.left == null && node.right == null);
    }
    private int floor(TreeNode node)
    {
        node = node.left;

        while (node.right != null)
            node = node.right;

        return node.val;
    }
    private int ceil(TreeNode node)
    {
        node = node.right;

        while (node.left != null)
            node = node.left;

        return node.val;
    }
    public TreeNode deleteNode(TreeNode root, int key)
    {
        if (root == null)
            return null;

        if (root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        else
        {
            if (isLeafNode(root))
                root = null;
            else if (root.right != null)
            {
                root.val = ceil(root);
                root.right = deleteNode(root.right, root.val);
            }
            else
            {
                root.val = floor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
