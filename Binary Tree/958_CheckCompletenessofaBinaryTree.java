/*
958. Check Completeness of a Binary Tree

Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

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
    private void traverse(TreeNode node, int index,
                          Map<Integer, Integer> map)
    {
        if (node == null)
            return;
    
        map.put(index, node.val);
        traverse(node.left, 2 * index + 1, map);
        traverse(node.right, 2 * index + 2, map);
    }
    public boolean isCompleteTree(TreeNode root) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        
        traverse(root, 0, map);
        for (int i = 0; i < map.size(); ++i)
            if (!map.containsKey(i))
                return false;
        
        return true;
    }
}