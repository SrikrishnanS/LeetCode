/*
549. Binary Tree Longest Consecutive Sequence II

Given the root of a binary tree, return the length of the longest consecutive path in the tree.

A consecutive path is a path where the values of the consecutive nodes in the path differ by one. This path can be either increasing or decreasing.

For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid.
On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

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
    private int[] longestConsecutive(TreeNode node, int[] maxLen)
    {
        int[] path = new int[]{0, 0}; // increasing, decreasing path len

        if (node == null)
            return path;
    
        path[0] = path[1] = 1;
        if (node.left  != null)
        {
            int[] left = longestConsecutive(node.left, maxLen);
            
            if (node.val == node.left.val + 1)
                path[1] = left[1] + 1;
            else if (node.val == node.left.val - 1)
                path[0] = left[0] + 1;
        }
        if (node.right  != null)
        {
            int[] right = longestConsecutive(node.right, maxLen);
        
            if (node.val == node.right.val + 1)
                path[1] = Math.max(path[1], right[1] + 1);
            else if (node.val == node.right.val - 1)
                path[0] = Math.max(path[0], right[0] + 1);
        }
        
        maxLen[0] = Math.max(maxLen[0], path[0] + path[1] - 1);
        return path;
    }
    
    public int longestConsecutive(TreeNode root) 
    {
        int [] maxLen = new int[1];
        
        longestConsecutive(root, maxLen);
        return maxLen[0];
    }
}
