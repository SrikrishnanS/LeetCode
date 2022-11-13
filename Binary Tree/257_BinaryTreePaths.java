/* 
257. Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.
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
    private void traverse(TreeNode node, String path, List<String> list)
    {
        path += node.val;
        
        if (node.left == null && node.right == null)
        {
            list.add(path);   // reached leaf node
            return;
        }

        if (node.left != null)
            traverse(node.left, path + "->", list);
        if (node.right != null)
            traverse(node.right, path + "->", list);
    }

    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> list = new ArrayList<String>();
        String path = "";
        
        traverse(root, path, list);
        return list;
    }
}
