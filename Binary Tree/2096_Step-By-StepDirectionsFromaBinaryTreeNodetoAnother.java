/* 2096. Step-By-Step Directions From a Binary Tree Node to Another

You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.
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
    
    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q)
    {
        if (root == null)
            return null;
        else if (root.val == p || root.val == q)
            return root;

        TreeNode left  = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null)
            return root;
        
        return (left != null) ? left : right;
    }
    
    private boolean buildPath(TreeNode node, int val, StringBuilder path)
    {
        boolean found = false;
        if (node == null)
            return false;
        else if (node.val == val)
            return true;
            
        if (buildPath(node.left, val, path))
        {
            path.insert(0, 'L');
            found = true;
        }
        else if (buildPath(node.right, val, path))
        {
            path.insert(0, 'R');
            found = true;
        }
        return found;        
    }
    
    public String getDirections(TreeNode root, int start, int end) 
    {
        StringBuilder startPath = new StringBuilder();
        StringBuilder endPath   = new StringBuilder();
        TreeNode parent;
        
        parent = lowestCommonAncestor(root, start, end);
        buildPath(parent, start, startPath);
        buildPath(parent, end, endPath);
    
        for (int i = 0; i < startPath.length(); ++i)
            startPath.setCharAt(i, 'U');
    
        return new String(startPath.append(endPath));
    }
}
