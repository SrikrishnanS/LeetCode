/* 1469. Find All The Lonely Nodes

In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.

Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.
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
    private void getLonelyNodes(TreeNode parent, TreeNode node,
                                List<Integer> list)
    {
        if (node == null)
            return;
        
        if (parent != null &&
            ((parent.left == node && parent.right == null) ||
             (parent.right == node && parent.left == null)))
                list.add(node.val);
        
        getLonelyNodes(node, node.left, list);
        getLonelyNodes(node, node.right, list);        
    }
    
    public List<Integer> getLonelyNodes(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();

        getLonelyNodes(null, root, list);
        return list;
    }
}