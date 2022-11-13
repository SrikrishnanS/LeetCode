/*
776. Split BST

Given the root of a binary search tree (BST) and an integer target, split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value. It Is not necessarily the case that the tree contains a node with the value target.

Additionally, most of the structure of the original tree should remain. Formally, for any child c with parent p in the original tree, if they are both in the same subtree after the split, then node c should still have the parent p.

Return an array of the two roots of the two subtrees.

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
    public TreeNode[] splitBST(TreeNode node, int target)
    {
        TreeNode [] result = null;

        if (node == null)
            result = new TreeNode[]{null, null};
        else if (node.val <= target)
        {
            result = splitBST(node.right, target);
            node.right = result[0];
            result[0] = node;
        }
        else
        {
            result = splitBST(node.left, target);
            node.left = result[1];
            result[1] = node;
        }
        return result;
    }
}
