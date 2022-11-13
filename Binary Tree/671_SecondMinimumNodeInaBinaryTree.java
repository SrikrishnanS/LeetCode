/*
671. Second Minimum Node In a Binary Tree

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

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
    private void traverse(TreeNode node, long[] min)
    {
        if (node != null)
        {
            if (node.val > min[0] && node.val < min[1])
                min[1] = (long)node.val;
            else if (node.val < min[1])
            {
                traverse(node.left, min);
                traverse(node.right, min);
            }
        }

    }
    public int findSecondMinimumValue(TreeNode root)
    {
        long [] min = new long[]{(long)root.val, Long.MAX_VALUE};

        traverse(root, min);
        return min[1] == Long.MAX_VALUE ? -1 : (int)min[1];
    }
}
