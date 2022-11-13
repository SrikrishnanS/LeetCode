/*
1026. Maximum Difference Between Node and Ancestor

Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

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
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root)
    {
        traverse(root, root.val, root.val);

        return this.maxDiff;
    }

    private void traverse(TreeNode node, int curMin, int curMax)
    {
        if (node == null)
            return;

        int diff = Math.max(Math.abs(node.val - curMin),
                            Math.abs(curMax - node.val));

        maxDiff  = Math.max(diff, maxDiff);

        curMin = Math.min(curMin, node.val);
        curMax = Math.max(curMax, node.val);

        traverse(node.left, curMin, curMax);
        traverse(node.right, curMin, curMax);
    }
}
