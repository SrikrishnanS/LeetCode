/*
298. Binary Tree Longest Consecutive Sequence

Given the root of a binary tree, return the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path needs to be from parent to child (cannot be the reverse).

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
    private void longestConsecutive(TreeNode node, TreeNode parent,
                                    int currLen, int[] maxLen)
    {
        if (node == null)
            return;
    
        if (parent != null && node.val == parent.val + 1)
        {
            ++currLen;
            maxLen[0] = Math.max(maxLen[0], currLen);
        }
        else
            currLen = 1;
        
        longestConsecutive(node.left, node, currLen, maxLen);
        longestConsecutive(node.right, node, currLen, maxLen);
    }

    public int longestConsecutive(TreeNode root)
    {
        int [] maxLen = new int[1];

        maxLen[0] = 1;
        longestConsecutive(root, null, 1, maxLen);
        return maxLen[0];
    }
}
