/*
113. Path Sum II

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

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
        return (node != null && node.left == null && node.right == null);
    }
    private void pathSum(TreeNode node, int target,
                         List<Integer> path, List<List<Integer>> result)
    {
        if (node == null)
            return;
        
        path.add(node.val);
        
        if (node.val == target && isLeafNode(node))
        {
            result.add(new ArrayList<Integer>(path)); // target leaf node reached
        }
        else 
        {        
            target -= node.val;
            pathSum(node.left, target, path, result);
            pathSum(node.right, target, path, result);
        }
    
        path.remove(path.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        pathSum(root, targetSum, new ArrayList<Integer>(), result);
        return result;
    }
}
