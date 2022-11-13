/* 
366. Find Leaves of Binary Tree

Given the root of a binary tree, collect a tree''s nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.
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
    // find the height of a node from the leaves (not root)
    private int traverse(TreeNode node, List<List<Integer>> result)
    {        
        List<Integer> list;
        if (node == null)
            return 0;
        
        int height = 1 + Math.max(traverse(node.left, result),
                                  traverse(node.right, result));
        
        if (result.size() < height)
            result.add(new ArrayList<Integer>());
        
        list = result.get(height - 1); 
        list.add(node.val);
        return height;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traverse(root, result);
        return result;
    }
}
